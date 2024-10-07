package Transaction;

import java.util.Date;

public class Transaction {
    private String transactionId;
    private Date transactionDate;
    private double amount;
    private String transactionType;

    // Constructor
    public Transaction(double amount, String transactionType) {
        this.transactionId = generateTransactionId();
        this.transactionDate = new Date(); // sets the current date and time
        this.amount = amount;
        this.transactionType = transactionType;
    }

    // Method to generate a unique transaction ID
    private String generateTransactionId() {
        return "TXN" + System.currentTimeMillis(); // Example using current timestamp
    }

    // Method to display transaction details
    public void displayTransactionDetails() {
        System.out.println("Transaction ID: " + transactionId);
        System.out.println("Transaction Date: " + transactionDate);
        System.out.println("Transaction Type: " + transactionType);
        System.out.println("Amount: " + amount);
    }

    // Getters and Setters for the attributes
    public String getTransactionId() {
        return transactionId;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    // Main method to test the class
    public static void main(String[] args) {
        Transaction transaction = new Transaction(150.00, "Deposit");
        
        // Display transaction details
        transaction.displayTransactionDetails();
    }
}
