package DSCoinPackage;

import HelperClasses.*;

import java.util.*;

public class DriverCodeMalicious {

    public static void main(String args[]) {


        Moderator mod = new Moderator();


        DSCoin_Malicious DSObj2 = new DSCoin_Malicious();
        DSObj2.pendingTransactions = new TransactionQueue();
        DSObj2.bChain = new BlockChain_Malicious();
        DSObj2.bChain.lastBlocksList = new TransactionBlock[100];
        Boolean correct2 = true;
        DSObj2.bChain.tr_count = 8;
        Members M1 = new Members();
        Members M2 = new Members();
        Members M3 = new Members();
        Members M4 = new Members();
        Members M5 = new Members();
        Members M6 = new Members();
        M1.UID = "201";
        M2.UID = "202";
        M3.UID = "203";
        M4.UID = "204";
        M5.UID = "205";
        M6.UID = "206";
        M1.mycoins = new ArrayList<Pair<String, TransactionBlock>>();
        M2.mycoins = new ArrayList<Pair<String, TransactionBlock>>();
        M3.mycoins = new ArrayList<Pair<String, TransactionBlock>>();
        M4.mycoins = new ArrayList<Pair<String, TransactionBlock>>();
        M5.mycoins = new ArrayList<Pair<String, TransactionBlock>>();
        M6.mycoins = new ArrayList<Pair<String, TransactionBlock>>();
        M1.in_process_trans = new Transaction[100];
        M2.in_process_trans = new Transaction[100];
        M3.in_process_trans = new Transaction[100];
        M4.in_process_trans = new Transaction[100];
        M5.in_process_trans = new Transaction[100];
        M6.in_process_trans = new Transaction[100];
        DSObj2.memberlist = new Members[6];
        DSObj2.memberlist[0] = M1;
        DSObj2.memberlist[1] = M2;
        DSObj2.memberlist[2] = M3;
        DSObj2.memberlist[3] = M4;
        DSObj2.memberlist[4] = M5;
        DSObj2.memberlist[5] = M6;


        try {
            mod.initializeDSCoin(DSObj2, 24);
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }


        System.out.println(DSObj2.bChain.lastBlocksList[0].dgst);
        System.out.println(DSObj2.bChain.lastBlocksList[0].nonce);


        Transaction T1 = new Transaction();
        Transaction T2 = new Transaction();
        Transaction T3 = new Transaction();
        Transaction T4 = new Transaction();
        Transaction T5 = new Transaction();
        Transaction T6 = new Transaction();
        Transaction T7 = new Transaction();
        Transaction T8 = new Transaction();

        T1.coinID = DSObj2.memberlist[0].mycoins.get(0).get_first();
        T1.Source = DSObj2.memberlist[0];
        T1.Destination = DSObj2.memberlist[1];
        T1.coinsrc_block = DSObj2.memberlist[0].mycoins.get(0).get_second();
        DSObj2.pendingTransactions.AddTransactions(T1);

        T2.coinID = DSObj2.memberlist[2].mycoins.get(0).get_first();
        T2.Source = DSObj2.memberlist[2];
        T2.Destination = DSObj2.memberlist[1];
        T2.coinsrc_block = DSObj2.memberlist[2].mycoins.get(0).get_second();
        DSObj2.pendingTransactions.AddTransactions(T2);

        T3.coinID = DSObj2.memberlist[2].mycoins.get(1).get_first();
        T3.Source = DSObj2.memberlist[2];
        T3.Destination = DSObj2.memberlist[1];
        T3.coinsrc_block = DSObj2.memberlist[2].mycoins.get(1).get_second();
        DSObj2.pendingTransactions.AddTransactions(T3);

        T4.coinID = DSObj2.memberlist[3].mycoins.get(0).get_first();
        T4.Source = DSObj2.memberlist[3];
        T4.Destination = DSObj2.memberlist[4];
        T4.coinsrc_block = DSObj2.memberlist[3].mycoins.get(0).get_second();
        DSObj2.pendingTransactions.AddTransactions(T4);

        T5.coinID = DSObj2.memberlist[3].mycoins.get(1).get_first();
        T5.Source = DSObj2.memberlist[3];
        T5.Destination = DSObj2.memberlist[4];
        T5.coinsrc_block = DSObj2.memberlist[3].mycoins.get(1).get_second();
        DSObj2.pendingTransactions.AddTransactions(T5);

        T6.coinID = DSObj2.memberlist[3].mycoins.get(2).get_first();
        T6.Source = DSObj2.memberlist[3];
        T6.Destination = DSObj2.memberlist[5];
        T6.coinsrc_block = DSObj2.memberlist[3].mycoins.get(2).get_second();
        DSObj2.pendingTransactions.AddTransactions(T6);

        T7.coinID = DSObj2.memberlist[0].mycoins.get(1).get_first();
        T7.Source = DSObj2.memberlist[0];
        T7.Destination = DSObj2.memberlist[5];
        T7.coinsrc_block = DSObj2.memberlist[0].mycoins.get(1).get_second();
        DSObj2.pendingTransactions.AddTransactions(T7);

        T8.coinID = DSObj2.memberlist[2].mycoins.get(2).get_first();
        T8.Source = DSObj2.memberlist[2];
        T8.Destination = DSObj2.memberlist[4];
        T8.coinsrc_block = DSObj2.memberlist[2].mycoins.get(2).get_second();
        DSObj2.pendingTransactions.AddTransactions(T8);


        try {
            M3.MineCoin(DSObj2);
        } catch (Exception e) {
        }
        System.out.println(DSObj2.bChain.lastBlocksList[0].dgst);
        System.out.println(DSObj2.bChain.lastBlocksList[0].nonce);


        DSCoin_Malicious DSObj3 = new DSCoin_Malicious();
        DSObj3.pendingTransactions = new TransactionQueue();
        DSObj3.bChain = new BlockChain_Malicious();
        DSObj3.bChain.lastBlocksList = new TransactionBlock[100];
        DSObj3.bChain.tr_count = 8;
        Members M_1 = new Members();
        Members M_2 = new Members();
        Members M_3 = new Members();
        Members M_4 = new Members();
        Members M_5 = new Members();
        Members M_6 = new Members();
        M_1.UID = "201";
        M_2.UID = "202";
        M_3.UID = "203";
        M_4.UID = "204";
        M_5.UID = "205";
        M_6.UID = "206";
        M_1.mycoins = new ArrayList<Pair<String, TransactionBlock>>();
        M_2.mycoins = new ArrayList<Pair<String, TransactionBlock>>();
        M_3.mycoins = new ArrayList<Pair<String, TransactionBlock>>();
        M_4.mycoins = new ArrayList<Pair<String, TransactionBlock>>();
        M_5.mycoins = new ArrayList<Pair<String, TransactionBlock>>();
        M_6.mycoins = new ArrayList<Pair<String, TransactionBlock>>();
        M_1.in_process_trans = new Transaction[100];
        M_2.in_process_trans = new Transaction[100];
        M_3.in_process_trans = new Transaction[100];
        M_4.in_process_trans = new Transaction[100];
        M_5.in_process_trans = new Transaction[100];
        M_6.in_process_trans = new Transaction[100];
        DSObj3.memberlist = new Members[6];
        DSObj3.memberlist[0] = M_1;
        DSObj3.memberlist[1] = M_2;
        DSObj3.memberlist[2] = M_3;
        DSObj3.memberlist[3] = M_4;
        DSObj3.memberlist[4] = M_5;
        DSObj3.memberlist[5] = M_6;

        try {
            mod.initializeDSCoin(DSObj3, 24);
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println(DSObj3.bChain.lastBlocksList[0].dgst);
        System.out.println(DSObj3.bChain.lastBlocksList[0].nonce);
        System.out.println(printDSObj(DSObj3));


        DSCoin_Honest obj = makeHonestObj(4, 8);
        Moderator Mood = new Moderator();
        Mood.initializeDSCoin(obj, 32);
        for (int i = 0; i < 10; i++) {
            obj.memberlist[i % 4].initiateCoinsend(obj.memberlist[(i + 1) % 4].UID, obj);
        }
        try {
            obj.memberlist[0].MineCoin(obj);
        } catch (Exception e) {
            System.out.println("My name is kira yoshikage, I am 33 years old");
        }
        for (int i = 0; i < 8; i++) {
            if (obj.bChain.lastBlock.trarray[i].Source != null) {
                try {
                    Pair<List<Pair<String, String>>, List<Pair<String, String>>> lists = obj.bChain.lastBlock.trarray[i].Source.finalizeCoinsend(obj.bChain.lastBlock.trarray[i], obj);
                    System.out.println(printLists(lists));
                } catch (Exception e) {
                    System.out.println("My name is kira yoshikage, I am 33 years old");
                }
            }
        }
        System.out.println(printDSObj(obj));


    }

    public static String printMember(Members m) {
        String s = "Member Name : ";
        s += m.UID + "\n Member Coins \n";
        for (Pair<String, TransactionBlock> p : m.mycoins) {
            s += p.first + " ";
        }
        s += "\n";
        return s;
    }

    public static String printBlock(TransactionBlock b) {
        String s = "Block Summary: ";
        s += b.trsummary + "\n Nonce ";
        if (b.nonce != null) {
            s += b.nonce + " \n dgst ";
        } else {
            s += "null \n dgst ";
        }
        if (b.dgst != null) {
            s += b.dgst + "\n";
        } else {
            s += "null \n";
        }
        return s;
    }

    public static String printBlockChain(BlockChain_Honest c) {
        String s = "Block Chain Honest \n ";
        TransactionBlock b = c.lastBlock;
        for (; b != null; b = b.previous) {
            s += printBlock(b) + "\n";
        }
        return s;
    }

    public static String printBlockChain(BlockChain_Malicious c) {
        String s = "Block Chain Malicious \n";
        List<TransactionBlock> l = new ArrayList<>();
        for (int i = 0; i < c.lastBlocksList.length; i++) {
            if (c.lastBlocksList[i] != null) {
                l.add(c.lastBlocksList[i]);
            }
        }
        for (int i = 1; i < l.size(); i++) {
            for (int j = i; j > 0 && l.get(j).trsummary.compareTo(l.get(j - 1).trsummary) <= 0; j--) {
                TransactionBlock temp = l.get(j);
                l.set(j, l.get(j - 1));
                l.set(j - 1, temp);
            }
        }
        for (int i = 0; i < l.size(); i++) {
            for (TransactionBlock b = l.get(i); b != null; b = b.previous) {
                s += printBlock(b) + "\n";
            }
        }
        return s;
    }

    public static String printDSObj(DSCoin_Honest o) {
        String s = "Honest Obj latest coin : ";
        s += o.latestCoinID + " \n Block Chain : \n";
        s += printBlockChain(o.bChain) + "memberlist \n";
        for (int i = 0; i < o.memberlist.length; i++) {
            s += printMember(o.memberlist[i]);
        }
        return s;
    }

    public static String printDSObj(DSCoin_Malicious o) {
        String s = "Malicious Obj latest coin : ";
        s += o.latestCoinID + " \n Block Chain : \n";
        s += printBlockChain(o.bChain) + "memberlist \n";
        for (int i = 0; i < o.memberlist.length; i++) {
            s += printMember(o.memberlist[i]);
        }
        return s;
    }

    public static String printLists(Pair<List<Pair<String, String>>, List<Pair<String, String>>> lists) {
        String s = "Lists: \n";
        for (int i = 0; i < lists.first.size(); i++) {
            s += lists.first.get(i).first + lists.first.get(i).second;
        }
        for (int i = 0; i < lists.second.size(); i++) {
            s += lists.second.get(i).first + lists.second.get(i).second;
        }
        return s;
    }

    public static DSCoin_Honest makeHonestObj(int memnum, int trcount) {
        DSCoin_Honest obj = new DSCoin_Honest();
        obj.pendingTransactions = new TransactionQueue();
        obj.memberlist = new Members[memnum];
        for (int i = 0; i < memnum; i++) {
            obj.memberlist[i] = new Members();
            obj.memberlist[i].UID = "Member " + Integer.toString(i);
            obj.memberlist[i].in_process_trans = new Transaction[100];
            obj.memberlist[i].mycoins = new ArrayList<>();

        }
        obj.bChain = new BlockChain_Honest();
        obj.bChain.tr_count = trcount;
        return obj;
    }
}


// Expected Output of the code

// All test cases pass!
// 00000A8BAD2C26E5A57CDE338C11BF2DD5CA86A49403F4048730418B086ED499
// 1000002168
// 00007911E2244B3A99271BC2B7797CD763E67600A8160F96D0C71EF79E81BFD6
// 1000018464
// 00000A8BAD2C26E5A57CDE338C11BF2DD5CA86A49403F4048730418B086ED499
// 1000002168
// Malicious Obj latest coin : 100023
//  Block Chain :
// Block Chain Malicious
// Block Summary: 21D46D6743CB76E51CCC3F97D45FB36439D22097EA6C8D830197535D3D9B62AC
//  Nonce 1000002168
//  dgst 00000A8BAD2C26E5A57CDE338C11BF2DD5CA86A49403F4048730418B086ED499

// Block Summary: 7B403A3BBBF3F4536C63339959FA911273DBD31C7A343B2F3BBF859048E4EA59
//  Nonce 1000061112
//  dgst 00005011ED18F79A2B1AF14F8D8A7A040E3473FBD4D273F0665081F00BE8806D

// Block Summary: E5373C82553982C3F9E7AF7D139AC4742D50EBA23B81A0F681A03E06B7C66D89
//  Nonce 1000014071
//  dgst 0000E18E7E085886C01F04F0DDCCFDB635C2E4C73A8BD016175CEE34ED35A07F

// memberlist
// Member Name : 201
//  Member Coins
// 100000 100006 100012 100018
// Member Name : 202
//  Member Coins
// 100001 100007 100013 100019
// Member Name : 203
//  Member Coins
// 100002 100008 100014 100020
// Member Name : 204
//  Member Coins
// 100003 100009 100015 100021
// Member Name : 205
//  Member Coins
// 100004 100010 100016 100022
// Member Name : 206
//  Member Coins
// 100005 100011 100017 100023

// Lists:
// F79DE6D621BC1DD16AE5635469FEC87F377A0FE3DF0F8C259DA9A62BE4C2361037BF8AA313822D1F6F56412378C0EC20133D0D1895C7AE54F3DD25C6D5BD28ED9BB072647D72FB5B3D16FB4F5C7386C7C1E5F28534ADF8FF623D17BA3278334E6B91E6CD1FEEB4D53DC5D67034E66F0F0DE2AE0CE21E78BB14DF96D9DD03DAE6B5A526FEDAAB31DC2AAAD5C38FDF644476E84745F2C73A0CF6B0B396201CDDA0B6EF448558548B90ACFCFC090A0ADC3B53F0C0B04FC2B6DA4BE78E771EE5DF99662AC1F1AB58C4A5BCF530BAFB63F7B9A4AD9A9A233980934A8DAE9EF3DCCBE0null000093F6917F7BC0B3EA6A7DE310860CA89BA5739998E7AAFD5B9DBF0222A2B6null0000BF3C377089B03F553F460AA04F350185A65047FF13EE20C8CB211ECA43B8000093F6917F7BC0B3EA6A7DE310860CA89BA5739998E7AAFD5B9DBF0222A2B6#662AC1F1AB58C4A5BCF530BAFB63F7B9A4AD9A9A233980934A8DAE9EF3DCCBE0#1000017575
// Lists:
// F79DE6D621BC1DD16AE5635469FEC87F377A0FE3DF0F8C259DA9A62BE4C2361037BF8AA313822D1F6F56412378C0EC20133D0D1895C7AE54F3DD25C6D5BD28ED9BB072647D72FB5B3D16FB4F5C7386C7C1E5F28534ADF8FF623D17BA3278334E6B91E6CD1FEEB4D53DC5D67034E66F0F0DE2AE0CE21E78BB14DF96D9DD03DAE6B5A526FEDAAB31DC2AAAD5C38FDF644476E84745F2C73A0CF6B0B396201CDDA0B6EF448558548B90ACFCFC090A0ADC3B53F0C0B04FC2B6DA4BE78E771EE5DF99662AC1F1AB58C4A5BCF530BAFB63F7B9A4AD9A9A233980934A8DAE9EF3DCCBE0null000093F6917F7BC0B3EA6A7DE310860CA89BA5739998E7AAFD5B9DBF0222A2B6null0000BF3C377089B03F553F460AA04F350185A65047FF13EE20C8CB211ECA43B8000093F6917F7BC0B3EA6A7DE310860CA89BA5739998E7AAFD5B9DBF0222A2B6#662AC1F1AB58C4A5BCF530BAFB63F7B9A4AD9A9A233980934A8DAE9EF3DCCBE0#1000017575
// Lists:
// 8DA70D4F70E933A65209C2A6628D2D04DB1D3B8EDFC9E26A208D0DBEFC6BF995068CB98138488A4C0D35230632DC5D1FE4F763DD152410108CE68D1B3975678B9BB072647D72FB5B3D16FB4F5C7386C7C1E5F28534ADF8FF623D17BA3278334E6B91E6CD1FEEB4D53DC5D67034E66F0F0DE2AE0CE21E78BB14DF96D9DD03DAE6B5A526FEDAAB31DC2AAAD5C38FDF644476E84745F2C73A0CF6B0B396201CDDA0B6EF448558548B90ACFCFC090A0ADC3B53F0C0B04FC2B6DA4BE78E771EE5DF99662AC1F1AB58C4A5BCF530BAFB63F7B9A4AD9A9A233980934A8DAE9EF3DCCBE0null000093F6917F7BC0B3EA6A7DE310860CA89BA5739998E7AAFD5B9DBF0222A2B6null0000BF3C377089B03F553F460AA04F350185A65047FF13EE20C8CB211ECA43B8000093F6917F7BC0B3EA6A7DE310860CA89BA5739998E7AAFD5B9DBF0222A2B6#662AC1F1AB58C4A5BCF530BAFB63F7B9A4AD9A9A233980934A8DAE9EF3DCCBE0#1000017575
// Lists:
// 8DA70D4F70E933A65209C2A6628D2D04DB1D3B8EDFC9E26A208D0DBEFC6BF995068CB98138488A4C0D35230632DC5D1FE4F763DD152410108CE68D1B3975678B9BB072647D72FB5B3D16FB4F5C7386C7C1E5F28534ADF8FF623D17BA3278334E6B91E6CD1FEEB4D53DC5D67034E66F0F0DE2AE0CE21E78BB14DF96D9DD03DAE6B5A526FEDAAB31DC2AAAD5C38FDF644476E84745F2C73A0CF6B0B396201CDDA0B6EF448558548B90ACFCFC090A0ADC3B53F0C0B04FC2B6DA4BE78E771EE5DF99662AC1F1AB58C4A5BCF530BAFB63F7B9A4AD9A9A233980934A8DAE9EF3DCCBE0null000093F6917F7BC0B3EA6A7DE310860CA89BA5739998E7AAFD5B9DBF0222A2B6null0000BF3C377089B03F553F460AA04F350185A65047FF13EE20C8CB211ECA43B8000093F6917F7BC0B3EA6A7DE310860CA89BA5739998E7AAFD5B9DBF0222A2B6#662AC1F1AB58C4A5BCF530BAFB63F7B9A4AD9A9A233980934A8DAE9EF3DCCBE0#1000017575
// Lists:
// 0700D068719C3AF28C5135995EF694E05D40607EB909AD1BF0A5DBE418FC2B9B930BC6A3F46D66A1BB1F66A893C6153971DF2327742BC563AECDE9DB72D400DA89FF7E113D1AFEDBAE7F798E162D1B73DAA8E90D35C668F90F1D2F8B3E1944E2646A61CED0AC72EC07135270B7B7E4BE21B624548961F278D27DBF0FEB93A18EB5A526FEDAAB31DC2AAAD5C38FDF644476E84745F2C73A0CF6B0B396201CDDA0B6EF448558548B90ACFCFC090A0ADC3B53F0C0B04FC2B6DA4BE78E771EE5DF99662AC1F1AB58C4A5BCF530BAFB63F7B9A4AD9A9A233980934A8DAE9EF3DCCBE0null000093F6917F7BC0B3EA6A7DE310860CA89BA5739998E7AAFD5B9DBF0222A2B6null0000BF3C377089B03F553F460AA04F350185A65047FF13EE20C8CB211ECA43B8000093F6917F7BC0B3EA6A7DE310860CA89BA5739998E7AAFD5B9DBF0222A2B6#662AC1F1AB58C4A5BCF530BAFB63F7B9A4AD9A9A233980934A8DAE9EF3DCCBE0#1000017575
// Lists:
// 0700D068719C3AF28C5135995EF694E05D40607EB909AD1BF0A5DBE418FC2B9B930BC6A3F46D66A1BB1F66A893C6153971DF2327742BC563AECDE9DB72D400DA89FF7E113D1AFEDBAE7F798E162D1B73DAA8E90D35C668F90F1D2F8B3E1944E2646A61CED0AC72EC07135270B7B7E4BE21B624548961F278D27DBF0FEB93A18EB5A526FEDAAB31DC2AAAD5C38FDF644476E84745F2C73A0CF6B0B396201CDDA0B6EF448558548B90ACFCFC090A0ADC3B53F0C0B04FC2B6DA4BE78E771EE5DF99662AC1F1AB58C4A5BCF530BAFB63F7B9A4AD9A9A233980934A8DAE9EF3DCCBE0null000093F6917F7BC0B3EA6A7DE310860CA89BA5739998E7AAFD5B9DBF0222A2B6null0000BF3C377089B03F553F460AA04F350185A65047FF13EE20C8CB211ECA43B8000093F6917F7BC0B3EA6A7DE310860CA89BA5739998E7AAFD5B9DBF0222A2B6#662AC1F1AB58C4A5BCF530BAFB63F7B9A4AD9A9A233980934A8DAE9EF3DCCBE0#1000017575
// Lists:
// BBF31D32A2F8F4A2521A3A64DDF928A215A550325E615F0180B374711D8AF761411DE5C80F45406825C2518398E3BCBF8619424938A84BD99274EF10339A0FE989FF7E113D1AFEDBAE7F798E162D1B73DAA8E90D35C668F90F1D2F8B3E1944E2646A61CED0AC72EC07135270B7B7E4BE21B624548961F278D27DBF0FEB93A18EB5A526FEDAAB31DC2AAAD5C38FDF644476E84745F2C73A0CF6B0B396201CDDA0B6EF448558548B90ACFCFC090A0ADC3B53F0C0B04FC2B6DA4BE78E771EE5DF99662AC1F1AB58C4A5BCF530BAFB63F7B9A4AD9A9A233980934A8DAE9EF3DCCBE0null000093F6917F7BC0B3EA6A7DE310860CA89BA5739998E7AAFD5B9DBF0222A2B6null0000BF3C377089B03F553F460AA04F350185A65047FF13EE20C8CB211ECA43B8000093F6917F7BC0B3EA6A7DE310860CA89BA5739998E7AAFD5B9DBF0222A2B6#662AC1F1AB58C4A5BCF530BAFB63F7B9A4AD9A9A233980934A8DAE9EF3DCCBE0#1000017575
// Honest Obj latest coin : 100032
//  Block Chain :
// Block Chain Honest
//  Block Summary: 662AC1F1AB58C4A5BCF530BAFB63F7B9A4AD9A9A233980934A8DAE9EF3DCCBE0
//  Nonce 1000017575
//  dgst 0000BF3C377089B03F553F460AA04F350185A65047FF13EE20C8CB211ECA43B8

// Block Summary: BF53491A73E0B79A6D08312A33B7B5BA8437EAE5AD3BE6A6791046AC6A6B4152
//  Nonce 1000030337
//  dgst 000093F6917F7BC0B3EA6A7DE310860CA89BA5739998E7AAFD5B9DBF0222A2B6

// Block Summary: 8AAFD5B47EA0A02264734D7C35B449AC4193DC21DB27FD3BDC13EB07FAB63D17
//  Nonce 1000031111
//  dgst 000044AE187B3D56CB1A634B97345D16A9A94BEBA0857C5F40E560F0A641ACC7

// Block Summary: B81A119A89DBB91D3F6A7F7218B79CC65065AE990ACA7757AEB2A23CF0C46CD4
//  Nonce 1000036536
//  dgst 0000ABC9F116EE4E7EE9AFC0E47F52FAD13FC5E7092D7A1498ACEC93C84C6222

// Block Summary: F06F11F69E6BABD3671DBC89C325B301A310A64B2A73853FCEE758B77EF5A6EA
//  Nonce 1000068652
//  dgst 0000EC877F4101B5EE13C400C78174112C5DE09C4C0B7492F9554CAE3B52D7CD

// memberlist
// Member Name : Member 0
//  Member Coins
// 100003 100012 100016 100020 100024 100028 100032
// Member Name : Member 1
//  Member Coins
// 100000 100004 100013 100017 100021 100025 100029
// Member Name : Member 2
//  Member Coins
// 100001 100005 100010 100014 100018 100022 100026 100030
// Member Name : Member 3
//  Member Coins
// 100002 100006 100011 100015 100019 100023 100027 100031