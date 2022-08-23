package DSCoinPackage;

import java.util.ArrayList;
import java.util.List;

public class TransactionQueue {

    public Transaction firstTransaction;
    public Transaction lastTransaction;
    public int numTransactions;

    // My attributes
    List<Transaction> transactionList = new ArrayList<>();

    public void AddTransactions(Transaction transaction) {
        if (firstTransaction == null) {
            firstTransaction = transaction;
            lastTransaction = transaction;
            numTransactions = 1;
            transactionList.add(transaction);
            return;
        }
        numTransactions++;
        transactionList.add(transaction);
        lastTransaction = transaction;
    }

    public Transaction RemoveTransaction() throws EmptyQueueException {

        if (numTransactions == 0) throw new EmptyQueueException();
        numTransactions--;
        if (firstTransaction == lastTransaction) {
            Transaction temp = firstTransaction;
            transactionList.remove(0);
            firstTransaction = null;
            lastTransaction = null;
            return temp;
        }
        Transaction temp = firstTransaction;
        transactionList.remove(0);
        firstTransaction = transactionList.get(0);
        return temp;
    }

    public int size() {
        return numTransactions;
    }
}
