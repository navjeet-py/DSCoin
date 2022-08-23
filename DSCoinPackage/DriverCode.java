package DSCoinPackage;

import HelperClasses.*;

import java.util.*;

public class DriverCode {

    public static void main(String args[]) {

        DSCoin_Honest DSObj = new DSCoin_Honest();
        DSObj.pendingTransactions = new TransactionQueue();
        DSObj.bChain = new BlockChain_Honest();
        Boolean correct = true;
        DSObj.bChain.tr_count = 4;
        Members m1 = new Members();
        Members m2 = new Members();
        Members m3 = new Members();
        Members m4 = new Members();
        m1.UID = "101";
        m2.UID = "102";
        m3.UID = "103";
        m4.UID = "104";
        m1.mycoins = new ArrayList<Pair<String, TransactionBlock>>();
        m2.mycoins = new ArrayList<Pair<String, TransactionBlock>>();
        m3.mycoins = new ArrayList<Pair<String, TransactionBlock>>();
        m4.mycoins = new ArrayList<Pair<String, TransactionBlock>>();
        m1.in_process_trans = new Transaction[100];
        m2.in_process_trans = new Transaction[100];
        m3.in_process_trans = new Transaction[100];
        m4.in_process_trans = new Transaction[100];
        DSObj.memberlist = new Members[4];
        DSObj.memberlist[0] = m1;
        DSObj.memberlist[1] = m2;
        DSObj.memberlist[2] = m3;
        DSObj.memberlist[3] = m4;


        Moderator mod = new Moderator();
        try {
            mod.initializeDSCoin(DSObj, 8);
        } catch (Exception e) {
            System.out.println(e);
        }


        m1.initiateCoinsend("102", DSObj);
        m3.initiateCoinsend("102", DSObj);
        m3.initiateCoinsend("102", DSObj);

        try {
            m2.MineCoin(DSObj);
            Pair<List<Pair<String, String>>, List<Pair<String, String>>>
                    temp = m1.finalizeCoinsend(DSObj.bChain.lastBlock.trarray[0], DSObj);
            temp = m3.finalizeCoinsend(DSObj.bChain.lastBlock.trarray[1], DSObj);
            temp = m3.finalizeCoinsend(DSObj.bChain.lastBlock.trarray[2], DSObj);
        } catch (Exception e) {
            e.printStackTrace();
        }


        m2.initiateCoinsend("101", DSObj);
        Transaction fake = new Transaction();
        fake.Source = m1;
        fake.Destination = m3;
        fake.coinsrc_block = DSObj.bChain.lastBlock;
        fake.coinID = "100000";
        DSObj.pendingTransactions.AddTransactions(fake);
        m2.initiateCoinsend("101", DSObj);
        m4.initiateCoinsend("101", DSObj);
        try {
            m3.MineCoin(DSObj);
            Pair<List<Pair<String, String>>, List<Pair<String, String>>> temp1 = m2.finalizeCoinsend(DSObj.bChain.lastBlock.trarray[0], DSObj);
            temp1 = m2.finalizeCoinsend(DSObj.bChain.lastBlock.trarray[1], DSObj);
            temp1 = m4.finalizeCoinsend(DSObj.bChain.lastBlock.trarray[2], DSObj);
        } catch (Exception e) {
            System.out.println(e);
        }

        correct &= DSObj.bChain.lastBlock.dgst.equals("00004F4D8749BFFE9E1BEF4152F6849BCD0A529B463FF0D409B338AFABF690C8");


        try {
            Transaction tobj = new Transaction();
            tobj.Source = m3;
            tobj.Destination = m2;
            tobj.coinID = "100002";
            Pair<List<Pair<String, String>>, List<Pair<String, String>>> p = m3.finalizeCoinsend(tobj, DSObj);

            correct &= p.get_first().get(0).get_first().equals("3A767231549E643B899B511E0BB1BD438C08A47D0E145B3A77CAFC4E5EF91DEF");
            correct &= p.get_first().get(1).get_first().equals("A86B49EA9F5245DEA4949D3815140D8CF5B1127C6EBB9B54197D87A5B0579C11");
            correct &= p.get_first().get(2).get_first().equals("036462EC76F2BEDA0CE4822E8747FEC9B69671359E7E3D2BD96485748360FD62");
            correct &= p.get_first().get(0).get_second().equals("B8444CE1F8BD43465F42E29A6E7335A29A12EAF96D4249E710098EE52A2027F2");
            correct &= p.get_first().get(1).get_second().equals("3A0E5A405EFB47DB8EB53FEF60C428FD85964E1C2E090DBC87000FEF02A04F0D");

            correct &= p.get_second().get(0).get_first().equals("00001DBCB949AF5097FE4F2D4CF1F545624ED5646931466170FCFB771D584D9C");
            correct &= p.get_second().get(1).get_first().equals("00009A7F99D2D09244E99D1F55AD29B49D335D9254A2EC682341ECFBC905AF4C");
            correct &= p.get_second().get(2).get_first().equals("00004F4D8749BFFE9E1BEF4152F6849BCD0A529B463FF0D409B338AFABF690C8");
            correct &= p.get_second().get(1).get_second().equals("00001DBCB949AF5097FE4F2D4CF1F545624ED5646931466170FCFB771D584D9C#036462EC76F2BEDA0CE4822E8747FEC9B69671359E7E3D2BD96485748360FD62#1000052544");
            correct &= p.get_second().get(2).get_second().equals("00009A7F99D2D09244E99D1F55AD29B49D335D9254A2EC682341ECFBC905AF4C#1CE221942486B63BD73A3D89082EF56FB5F0B2DB6B0D87EA8D81557B8A26D4AD#1000188337");

            if (correct == true) {
                System.out.println("All test cases pass!");
            } else {
                System.out.println("Some test case are incorrect!");
            }

        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }
}
