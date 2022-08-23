package DSCoinPackage;

import HelperClasses.CRF;
import HelperClasses.MerkleTree;

import java.util.ArrayList;
import java.util.List;

public class BlockChain_Malicious {

    public int tr_count;
    public static final String start_string = "DSCoin";
    public TransactionBlock[] lastBlocksList;

    public static boolean checkTransactionBlock(TransactionBlock tB) {
        CRF crf = new CRF(64);
        if (!tB.dgst.substring(0, 4).equals("0000")) return false;
        if (tB.previous == null) {
            if (!crf.Fn(start_string + "#" + tB.trsummary + "#" + tB.nonce).equals(tB.dgst))
                return false;
        } else {
            if (!crf.Fn(tB.previous.dgst + "#" + tB.trsummary + "#" + tB.nonce).equals(tB.dgst))
                return false;
        }
        MerkleTree tree = new MerkleTree();
        tree.Build(tB.trarray);
        if (!tree.rootnode.val.equals(tB.trsummary)) return false;
        // DOUBT HERE
        for (Transaction tr : tB.trarray) {
            if (!tB.checkTransaction(tr)) return false;
        }
        return true;

    }

    public TransactionBlock FindLongestValidChain() {

        int max_length = 0;
        TransactionBlock final_answer = null;


        for (TransactionBlock tB : lastBlocksList) {
            if (tB == null) continue;

            List<TransactionBlock> allBlocks = new ArrayList<>();
            while (true) {
                allBlocks.add(0, tB);
                if (tB.previous == null) break;
                tB = tB.previous;
            }
            TransactionBlock answer = allBlocks.get(0);
            int length = 0;
            for (TransactionBlock block : allBlocks) {
                if (!checkTransactionBlock(block)) {
                    break;
                }
                answer = block;
                length++;
            }

            if (length > max_length) {
                max_length = length;
                final_answer = answer;
            }
        }
        return final_answer;

    }

    public void InsertBlock_Malicious(TransactionBlock newBlock) {
        CRF crf = new CRF(64);

        boolean is_empty = true;
        for (TransactionBlock tB : lastBlocksList) if (tB != null) is_empty = false;
        if (is_empty) {
            newBlock.nonce = calculate_nonce(start_string + "#" + newBlock.trsummary + "#");
            newBlock.dgst = crf.Fn(start_string + "#" + newBlock.trsummary + "#" + newBlock.nonce);
            newBlock.previous = null;
            lastBlocksList[0] = newBlock;
            return;
        }


        TransactionBlock lastBlock = FindLongestValidChain();
        System.out.println(lastBlock.dgst);
        newBlock.nonce = calculate_nonce(lastBlock.dgst + "#" + newBlock.trsummary + "#");
        newBlock.dgst = crf.Fn(lastBlock.dgst + "#" + newBlock.trsummary + "#" + newBlock.nonce);
        newBlock.previous = lastBlock;

        boolean isThere = false;
        for (int i = 0; i < lastBlocksList.length; i++) {
            if (lastBlocksList[i] == null) continue;
            if (lastBlocksList[i].equals(lastBlock)) {
                isThere = true;
                lastBlocksList[i] = newBlock;
                break;
            }
        }

        if (!isThere) {
            for (int i = 0; i < lastBlocksList.length; i++) {
                if (lastBlocksList[i] == null) {
                    lastBlocksList[i] = newBlock;
                }
            }
        }
    }

    // CORRECT BELOW
    public static String calculate_nonce(String initial) {
        CRF crf = new CRF(64);
        long nonce = 1000000001;
        while (true) {
            if (crf.Fn(initial + Long.toString(nonce)).startsWith("0000")) {
                return Long.toString(nonce);
            }
            nonce++;
        }
    }

}
