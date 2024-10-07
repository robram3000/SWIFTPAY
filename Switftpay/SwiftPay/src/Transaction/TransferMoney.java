package Transaction;

public class TransferMoney {
    private String senderAccount;
    private String receiverAccount;
    private double amount;
    private String transactionId;

    // Constructor
    public TransferMoney(String senderAccount, String receiverAccount, double amount) {
        this.senderAccount = senderAccount;
        this.receiverAccount = receiverAccount;
        this.amount = amount;
        this.transactionId = generateTransactionId();
    }

    // Method to transfer money
    public boolean transfer() {
        if (validateTransfer()) {
            // Logic to deduct money from sender and add to receiver
            System.out.println("Transfer of " + amount + " from " + senderAccount + " to " + receiverAccount + " successful.");
            return true;
        } else {
            System.out.println("Transfer failed: Invalid transaction.");
            return false;
        }
    }

    // Validate the transfer conditions
    private boolean validateTransfer() {
        // You can add more complex validation logic here
        return amount > 0 && senderAccount != null && receiverAccount != null;
    }

    // Generate a unique transaction ID (simple example)
    private String generateTransactionId() {
        return "TX" + System.currentTimeMillis(); // Example of unique ID using the current timestamp
    }

    // Getters for the attributes (optional)
    public String getSenderAccount() {
        return senderAccount;
    }

    public String getReceiverAccount() {
        return receiverAccount;
    }

    public double getAmount() {
        return amount;
    }

    public String getTransactionId() {
        return transactionId;
    }

    // Main method to test the class
    public static void main(String[] args) {
        TransferMoney transfer = new TransferMoney("123456", "654321", 250.00);
        
        // Perform the transfer
        if (transfer.transfer()) {
            System.out.println("Transaction ID: " + transfer.getTransactionId());
        } else {
            System.out.println("Transaction failed.");
        }
    }
}
