package DSCoinPackage;

public class MissingTransactionException extends Exception {

    public MissingTransactionException() {
        System.out.println("Required transaction missing from block chain!");
    }

}