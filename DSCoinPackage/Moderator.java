package DSCoinPackage;

import HelperClasses.Pair;

public class Moderator {

    public void initializeDSCoin(DSCoin_Honest DSObj, int coinCount) {

        int rounds = coinCount / DSObj.bChain.tr_count;
        int next_coin = 100000;
        int next_member = 0;
        Members mod = new Members();
        mod.UID = "Moderator";

        for (int round = 0; round < rounds; round++) {
            Transaction[] trarray = new Transaction[DSObj.bChain.tr_count];
            int idx = 0;
            for (int i = 0; i < DSObj.bChain.tr_count; i++) {
                Transaction tr = new Transaction();
                tr.coinID = Integer.toString(next_coin);
                tr.Source = mod;
                tr.coinsrc_block = null;
                tr.Destination = DSObj.memberlist[next_member];
                trarray[idx] = tr;

                DSObj.latestCoinID = tr.coinID;
                next_member++;
                next_member %= DSObj.memberlist.length;
                idx++;
                next_coin++;
            }
            TransactionBlock tB = new TransactionBlock(trarray);
            DSObj.bChain.InsertBlock_Honest(tB);
            for (Transaction tr : trarray) {
                tr.Destination.mycoins.add(new Pair<>(tr.coinID, tB));
            }
        }
    }

    public void initializeDSCoin(DSCoin_Malicious DSObj, int coinCount) {

        int rounds = coinCount / DSObj.bChain.tr_count;
        int next_coin = 100000;
        int next_member = 0;
        Members mod = new Members();
        mod.UID = "Moderator";

        for (int round = 0; round < rounds; round++) {
            Transaction[] trarray = new Transaction[DSObj.bChain.tr_count];
            int idx = 0;
            for (int i = 0; i < DSObj.bChain.tr_count; i++) {
                Transaction tr = new Transaction();
                tr.coinID = Integer.toString(next_coin);
                tr.Source = mod;
                tr.coinsrc_block = null;
                tr.Destination = DSObj.memberlist[next_member];
                trarray[idx] = tr;

                DSObj.latestCoinID = tr.coinID;
                next_member++;
                next_member %= DSObj.memberlist.length;
                idx++;
                next_coin++;
            }
            TransactionBlock tB = new TransactionBlock(trarray);
            DSObj.bChain.InsertBlock_Malicious(tB);
            for (Transaction tr : trarray) {
                tr.Destination.mycoins.add(new Pair<>(tr.coinID, tB));
            }
        }
    }
}
