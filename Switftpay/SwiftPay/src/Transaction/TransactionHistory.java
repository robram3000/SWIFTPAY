package Transaction;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TransactionHistory {
    // Inner class to represent a transaction
    public static class Transaction {
        private String transactionId;
        private double amount;
        private Date date;
        private String description;

        public Transaction(String transactionId, double amount, Date date, String description) {
            this.transactionId = transactionId;
            this.amount = amount;
            this.date = date;
            this.description = description;
        }

        // Getters
        public String getTransactionId() {
            return transactionId;
        }

        public double getAmount() {
            return amount;
        }

        public Date getDate() {
            return date;
        }

        public String getDescription() {
            return description;
        }

        @Override
        public String toString() {
            return "Transaction{" +
                    "transactionId='" + transactionId + '\'' +
                    ", amount=" + amount +
                    ", date=" + date +
                    ", description='" + description + '\'' +
                    '}';
        }
    }

    private List<Transaction> transactions;

    public TransactionHistory() {
        transactions = new ArrayList<>();
    }

    // Method to add a transaction
    public void addTransaction(String transactionId, double amount, Date date, String description) {
        Transaction transaction = new Transaction(transactionId, amount, date, description);
        transactions.add(transaction);
    }

    // Method to retrieve all transactions
    public List<Transaction> getTransactions() {
        return transactions;
    }

    // Method to get a transaction by its ID
    public Transaction getTransactionById(String transactionId) {
        for (Transaction transaction : transactions) {
            if (transaction.getTransactionId().equals(transactionId)) {
                return transaction;
            }
        }
        return null; // or throw an exception if preferred
    }

    @Override
    public String toString() {
        return "TransactionHistory{" +
                "transactions=" + transactions +
                '}';
    }
}
