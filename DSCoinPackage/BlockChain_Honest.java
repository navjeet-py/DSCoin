package DSCoinPackage;

import HelperClasses.CRF;

public class BlockChain_Honest {

    public int tr_count;
    public static final String start_string = "DSCoin";
    public TransactionBlock lastBlock;

    public void InsertBlock_Honest(TransactionBlock newBlock) {
        CRF crf = new CRF(64);

        if (lastBlock == null) {
            newBlock.nonce = calculate_nonce(start_string + "#" + newBlock.trsummary + "#");
            newBlock.dgst = crf.Fn(start_string + "#" + newBlock.trsummary + "#" + newBlock.nonce);
            lastBlock = newBlock;
            return;
        }
        newBlock.nonce = calculate_nonce(lastBlock.dgst + "#" + newBlock.trsummary + "#");
        newBlock.dgst = crf.Fn(lastBlock.dgst + "#" + newBlock.trsummary + "#" + newBlock.nonce);
        newBlock.previous = lastBlock;
        lastBlock = newBlock;
    }

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
