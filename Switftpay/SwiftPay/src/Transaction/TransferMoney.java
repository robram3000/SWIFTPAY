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
    public boolean transfer() {
        if (validateTransfer()) {
            
            System.out.println("Transfer of " + amount + " from " + senderAccount + " to " + receiverAccount + " successful.");
            return true;
        } else {
            System.out.println("Transfer failed: Invalid transaction.");
            return false;
        }
    }
    private boolean validateTransfer() {
        return amount > 0 && senderAccount != null && receiverAccount != null;
    }
    private String generateTransactionId() {
        return "TX" + System.currentTimeMillis(); 
    }

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
}
