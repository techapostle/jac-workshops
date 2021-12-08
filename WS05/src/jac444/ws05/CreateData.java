/*
 * Modified to include method() addTransaction()
 */

package jac444.ws05;

import java.io.FileNotFoundException;
import java.lang.SecurityException;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class CreateData {
    private Formatter masterFileOutput;
    private Formatter transactionRecordFileOutput;
    private Scanner input;

    public CreateData() {}

    public void openFile() {
        try {
            masterFileOutput = new Formatter("oldmast.txt");
            transactionRecordFileOutput = new Formatter("trans.txt");
        } catch (SecurityException securityException) {
            System.err.println("You do not have write access to this file.");
        }
        catch (FileNotFoundException fileNotFoundException) {
            System.err.println("Error opening or creating file.");
        }
    }

    public void addRecords(AccountRecord[] account){
        try {
            for (AccountRecord accountRecord : account) {
                if (accountRecord.getAccount() > 0)
                    masterFileOutput.format("%d %s %s %.2f%n", accountRecord.getAccount(), accountRecord.getfName(), accountRecord.getlName(), accountRecord.getBalance());
                else
                    System.out.println("Account number must be greater than 0.");
            }
        } catch (FormatterClosedException formatterClosedException) {
            System.err.println("Error writing to file.");
        } catch (NoSuchElementException elementException) {
            System.err.println("Invalid input. Please try again.");
            input.nextLine();
        }
    }

    public void addTransactions(TransactionRecord[] transactions) {
        try {
            for (TransactionRecord transaction : transactions) {
                if (transaction.getAccountNo() > 0)
                    transactionRecordFileOutput.format("%d %.2f%n", transaction.getAccountNo(), transaction.getAmount());
                else
                    System.out.println("Account number must be greater than 0.");
            }
        } catch (FormatterClosedException formatterClosedException) {
            System.err.println("Error writing to file.");
        } catch (NoSuchElementException elementException){
            System.err.println("Invalid input. Please try again.");
            input.nextLine();
        }
    }

    public void closeFile() {
        if (masterFileOutput != null)
            masterFileOutput.close();
        if (transactionRecordFileOutput != null)
            transactionRecordFileOutput.close();
    }
}