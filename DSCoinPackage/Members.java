package DSCoinPackage;

import java.util.*;

import HelperClasses.MerkleTree;
import HelperClasses.Pair;
import HelperClasses.TreeNode;

public class Members {

    public String UID;
    public List<Pair<String, TransactionBlock>> mycoins;
    public Transaction[] in_process_trans;
//    public List<Transaction> in_process_trans;

    public void initiateCoinsend(String destUID, DSCoin_Honest DSobj) {

        Pair<String, TransactionBlock> coin = mycoins.get(0);
        mycoins.remove(0);
        Transaction tobj = new Transaction();
        tobj.coinID = coin.first;
        tobj.coinsrc_block = coin.second;
        tobj.Source = this;
        for (Members member : DSobj.memberlist) {
            if (member.UID.equals(destUID)) {
                tobj.Destination = member;
                break;
            }
        }
        for (int i = 0; i < in_process_trans.length; i++) {
            if (in_process_trans[i] == null) {
                in_process_trans[i] = tobj;
                break;
            }
        }
        DSobj.pendingTransactions.AddTransactions(tobj);
    }


    public Pair<List<Pair<String, String>>, List<Pair<String, String>>> finalizeCoinsend(Transaction tobj, DSCoin_Honest DSObj) throws MissingTransactionException {

        TransactionBlock tB = DSObj.bChain.lastBlock;
        int id = -1;
        while (true) {
            if (tB == null) {
                throw new MissingTransactionException();
            }
            boolean found = false;
            int i = 0;
            for (Transaction tr : tB.trarray) {
                if (tr.coinID == null || tr.Destination == null || tr.Source == null) continue;
                if (tr.coinID.equals(tobj.coinID) & tr.Source.equals(tobj.Source)
                        & tr.Destination.equals(tobj.Destination)) {
                    found = true;
                    id = i;
                    break;
                }
                i++;
            }
            if (found) break;
            tB = tB.previous;
        }

        MerkleTree newMerkleTree = tB.Tree;

        int total_depth = (int) (Math.log(newMerkleTree.numdocs) / Math.log(2));
        ArrayList<Pair<String, String>> mtree_path = new ArrayList<>();
        for (int i = 0; i < total_depth + 1; i++) mtree_path.add(null);
        int total = (newMerkleTree.numdocs) / 2;
        TreeNode current = newMerkleTree.rootnode;
        mtree_path.set(total_depth, new Pair<>(newMerkleTree.rootnode.val, null));
        for (int index = total_depth - 1; index >= 0; index--) {
            mtree_path.set(index, new Pair<>(current.left.val, current.right.val));
            if ((total & (id)) != 0) current = current.right;
            else current = current.left;
            total = total / 2;
        }

        ArrayList<Pair<String, String>> queue_path = new ArrayList<>();

        TransactionBlock last = DSObj.bChain.lastBlock;
        while (true) {
            queue_path.add(0, new Pair<>(last.dgst, last.previous.dgst + "#" + last.trsummary + "#" + last.nonce));
            if (last == tB) {
                queue_path.add(0, new Pair<>(tB.previous.dgst, null));
                break;
            }
            last = last.previous;
        }

        for (int i = 0; i < in_process_trans.length; i++) {
            if (in_process_trans[i] == tobj) {
                in_process_trans[i] = null;
            }
        }

        tobj.Destination.mycoins.add(new Pair<>(tobj.coinID, tB));
        tobj.Destination.mycoins.sort(new Comparator<Pair<String, TransactionBlock>>() {
            @Override
            public int compare(Pair<String, TransactionBlock> o1, Pair<String, TransactionBlock> o2) {
                return Integer.compare(Integer.parseInt(o1.first), Integer.parseInt(o2.first));
            }
        });
        return new Pair<>(mtree_path, queue_path);
    }

    public void MineCoin(DSCoin_Honest DSObj) throws EmptyQueueException {

        int tr_count = DSObj.bChain.tr_count;
        HashMap<String, Integer> map = new HashMap<>();
        Transaction[] trarray = new Transaction[tr_count];
        int cnt = 0;
        while (cnt < tr_count - 1) {
            Transaction tr = DSObj.pendingTransactions.RemoveTransaction();
            if (map.containsKey(tr.coinID)) continue;
            // checking the double spending before adding this into the block.
            if (!DSObj.bChain.lastBlock.checkTransaction(tr)) continue;

            map.put(tr.coinID, 1);
            trarray[cnt] = tr;
            cnt++;

        }


        Transaction minerRewardTransaction = new Transaction();
        minerRewardTransaction.coinID = Integer.toString(Integer.parseInt(DSObj.latestCoinID) + 1);
        minerRewardTransaction.Source = null;
        minerRewardTransaction.Destination = this;
        minerRewardTransaction.coinsrc_block = null;
        trarray[tr_count - 1] = minerRewardTransaction;

        TransactionBlock tB = new TransactionBlock(trarray);
        DSObj.bChain.InsertBlock_Honest(tB);

        mycoins.add(new Pair<>(minerRewardTransaction.coinID, null));
        mycoins.sort(Comparator.comparingInt(o -> Integer.parseInt(o.first)));

        DSObj.latestCoinID = minerRewardTransaction.coinID;
    }

    public void MineCoin(DSCoin_Malicious DSObj) throws EmptyQueueException {

        int tr_count = DSObj.bChain.tr_count;
        HashMap<String, Integer> map = new HashMap<>();
        Transaction[] trarray = new Transaction[tr_count];
        int cnt = 0;
        while (cnt < tr_count - 1) {
            Transaction tr = DSObj.pendingTransactions.RemoveTransaction();
            if (!map.containsKey(tr.coinID)) {
                map.put(tr.coinID, 1);
                trarray[cnt] = tr;
                cnt++;
            }
        }


        Transaction minerRewardTransaction = new Transaction();
        minerRewardTransaction.coinID = Integer.toString(Integer.parseInt(DSObj.latestCoinID) + 1);
        minerRewardTransaction.Source = null;
        minerRewardTransaction.Destination = this;
        minerRewardTransaction.coinsrc_block = null;
        trarray[tr_count - 1] = minerRewardTransaction;

        TransactionBlock tB = new TransactionBlock(trarray);
        DSObj.bChain.InsertBlock_Malicious(tB);

        mycoins.add(new Pair<>(minerRewardTransaction.coinID, null));
        mycoins.sort(Comparator.comparingInt(o -> Integer.parseInt(o.first)));

        DSObj.latestCoinID = minerRewardTransaction.coinID;
    }
}
