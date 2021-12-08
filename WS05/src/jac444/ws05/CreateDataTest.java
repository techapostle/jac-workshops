package jac444.ws05;

public class CreateDataTest {
    public static void main(String[] args) {
        AccountRecord[] accounts = new AccountRecord[4];
        TransactionRecord[] transactions = new TransactionRecord[4];
        // create account records
        accounts[0] = new AccountRecord(100, "Alan", "Jones", 348.17 );
        accounts[1] = new AccountRecord(300, "Mary", "Smith", 27.19 );
        accounts[2] = new AccountRecord(500, "Sam", "Sharp", 0.00 );
        accounts[3] = new AccountRecord(700, "Suzy", "Green", -14.22 );
        // create transactions
        transactions[0] = new TransactionRecord(100, 27.14);
        transactions[1] = new TransactionRecord(300, 62.11);
        transactions[2] = new TransactionRecord(400, 100.56);
        transactions[3] = new TransactionRecord(900, 82.17);

        CreateData application = new CreateData();
        application.openFile();
        application.addRecords(accounts);
        application.addTransactions(transactions);
        application.closeFile();

        FileMatch match = new FileMatch();
        match.openFiles();
        match.processRecords();
        match.closeFile();
    }
}