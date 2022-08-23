package DSCoinPackage;

import HelperClasses.MerkleTree;
import HelperClasses.CRF;

public class TransactionBlock {

    public Transaction[] trarray;
    public TransactionBlock previous;
    public MerkleTree Tree;
    public String trsummary;
    public String nonce;
    public String dgst;

    TransactionBlock(Transaction[] t) {
        this.trarray = new Transaction[t.length];
        for (int i = 0; i < t.length; i++) this.trarray[i] = t[i];
        this.previous = null;
        this.Tree = new MerkleTree();
        Tree.Build(this.trarray);
        this.trsummary = this.Tree.rootnode.val;
        this.dgst = null;
    }

    public boolean checkTransaction(Transaction t) {

        if (t.coinsrc_block == null) return true;
        TransactionBlock block = t.coinsrc_block;
        boolean found = false;

        for (Transaction tr : block.trarray) {
            if (tr.coinID.equals(t.coinID) & tr.Destination.equals(t.Source)) {
                found = true;
                break;
            }
        }
        if (!found) return false;

        TransactionBlock cur = this;

        while (true) {
            if (cur.equals(block)) return true;
            for (Transaction tr : cur.trarray) {
                if (tr.coinID.equals(t.coinID)) {
                    return false;
                }
            }
            cur = cur.previous;
        }
    }
}
