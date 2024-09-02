package Transaction;

public abstract class CheckBalance extends Transaction {

    protected abstract boolean checkBalanceInDatabase();


    public boolean checkingBalance(boolean check) {
        if (check) {
            return checkBalanceInDatabase();
        }
        return false;
    }

    public void checkingBalanceInDatabase() {

    }
}
