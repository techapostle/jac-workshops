/*
 * Performs file matching functionality between current transactions and oldmast
 */

package jac444.ws05;

import java.util.Scanner;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.IllegalFormatException;
import java.io.File;
import java.lang.IllegalStateException;
import java.util.NoSuchElementException;

public class FileMatch {
    private Scanner inOld, inTrans;
    private Formatter newMaster, log;
    private int matchedAccount;
    private TransactionRecord transaction;
    private AccountRecord account;

    public FileMatch() {
        account = new AccountRecord();
        transaction = new TransactionRecord();
        matchedAccount = 0;
    }

    public void openFiles() {
        try {
            inOld = new Scanner(new File("oldmast.txt"));
            inTrans = new Scanner(new File("trans.txt"));
            newMaster = new Formatter("newmast.txt");
            log = new Formatter("log.txt");
        } catch(Exception ex) {
            System.err.println("Error opening the files. Exception: " + ex);
        }
    }

    public AccountRecord returnAccountRecord() {
        try {
            if (inOld.hasNext()) {
                if (account.getfName() != null) {
                    account.setAccount(inOld.nextInt());
                    account.setfName(inOld.next());
                    account.setlName(inOld.next());
                    account.setBalance(inOld.nextDouble());
                }

            }
        } catch(NoSuchElementException elementException) {
            System.err.println("File improperly formed.");
            inOld.close();
        } catch(IllegalStateException stateException) {
            System.err.println("Error reading from file.");
        } catch(Exception ex) {
            System.err.println("Exception occurred: " + ex);
        }
        return account;
    }

    public TransactionRecord returnTransactionRecord() {
        try {
            if (inTrans.hasNext()) {
                transaction.setAccountNo(inTrans.nextInt());
                transaction.setAmount(inTrans.nextDouble());
            }
        } catch(NoSuchElementException elementException) {
            System.err.println("File improperly formed.");
            inTrans.close();
        } catch(IllegalStateException stateException) {
            System.err.println("Error reading from file.");
        }
        return transaction;
    }

    public void processRecords() {
        int transactionNumber, accountNumber;

        try {
            // get a transaction record and its account number
            transaction = returnTransactionRecord();
            // if the transaction is null, we are done
            if (transaction == null) return;
            transactionNumber = transaction.getAccountNo();
            // get an account record and its account number
            account = returnAccountRecord();
            // if the account is null, we are done
            if (account == null) return;
            accountNumber = account.getAccount();
            // create headings for log file  and new master file
            newMaster.format("%-10s%-12s%-12s%10s%n", "Account", "First Name", "Last Name", "Balance");
            while (inOld.hasNextLine() || inTrans.hasNextLine()) {
                // SCENARIO ONE -- there is NO transaction for this account
                /*
                 * When there's a master record for a particular account, but no corresponding transaction record, merely
                 * write the master record to "newmast.txt".
                 */
                if (this.matchedAccount != transactionNumber) {
                    this.matchedAccount = transactionNumber;
                } else {
                    break;
                }
                if (accountNumber < transactionNumber) {
                    // write to the master file
                    newMaster.format("%d %s %s %.2f%n", account.getAccount(), account.getfName(), account.getlName(), account.getBalance());
                    // write to the log file
                    log.format("Unmatched transaction record for account number...%d %.2f%n", transaction.getAccountNo(), transaction.getAmount());
                    // get a new transaction
                    transaction = returnTransactionRecord();
                    if (transaction == null) {
                        System.out.println("Transaction is null");
                        return;
                    }
                    transactionNumber = transaction.getAccountNo();
                    // get a new account
                    account = returnAccountRecord();
                    if (account == null) return;
                    accountNumber = account.getAccount();
                }
                // SCENARIO TWO -- there IS a transaction for this account
                else if (accountNumber == transactionNumber) {
                    // combine the records
                    account.setBalance(account.getBalance() + transaction.getAmount());
                    // write to the master file
                    newMaster.format("%d %s %s %.2f%n", account.getAccount(), account.getfName(), account.getlName(), account.getBalance());
                    // get a new transaction
                    transaction = returnTransactionRecord();
                    if (transaction == null) return;
                    transactionNumber = transaction.getAccountNo();
                    // get a new account
                    account = returnAccountRecord();
                    if (account == null) return;
                    accountNumber = account.getAccount();
                }
                // SCENARIO THREE -- there is NO ACCOUNT for this transaction
                /*
                 * When there's a transaction record, but no corresponding master record, print to a log file the message
                 * "Unmatched transaction record for account number..." (fill in the account number from the transaction record).
                 */
                else if (transactionNumber < accountNumber) {
                    // write to the log file
                    log.format("Unmatched transaction record for account number...%d %.2f%n", transaction.getAccountNo(), transaction.getAmount());
                    // get a new transaction
                    transaction = returnTransactionRecord();
                    if (transaction == null) return;
                    transactionNumber = transaction.getAccountNo();
                    // write to the master file
                    newMaster.format("%d %s %s %.2f%n", account.getAccount(), account.getfName(), account.getlName(), account.getBalance());
                    // get a new account
                    account = returnAccountRecord();
                    if (account == null) return;
                    accountNumber = account.getAccount();
                }
            }
        } catch(FormatterClosedException closedException) {
            System.err.println("Error writing to file - file has been closed.");
        } catch(IllegalFormatException formatException) {
            System.err.println("Error with output.");
        }
    }
    // close file and terminate application
    public void closeFile() {
        // close inOldMaster
        if (inOld != null)
            inOld.close(); // close file
        // close inTransaction
        if (inTrans != null)
            inTrans.close(); // close file
        // close new master file
        if (newMaster != null)
            newMaster.close(); // close file
        // close log file
        if (log != null)
            log.close(); // close file
    } // end method closeFile
}