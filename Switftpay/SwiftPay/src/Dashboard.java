import java.util.Scanner;

public class Dashboard {
    private double balance;
    private Scanner scanner;

    
    public Dashboard() {
        this.balance = 0.0; 
        this.scanner = new Scanner(System.in);
    }

    public String interfaceDashboard() {
        System.out.println("SUMMARY DASHBOARD ACCOUNT ");
        System.out.println("Balance: $" + String.format("%.2f", balance));
        System.out.println();

        System.out.println("Choose an option:");
        System.out.println("1. Deposit");
        System.out.println("2. Withdraw");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                deposit();
                break;
            case 2:
                withdraw();
                break;
            case 3:
                checkBalance();
                break;
            case 4:
                System.out.println("Goodbye!");
                return "Goodbye!";
            default:
                System.out.println("Invalid choice. Please try again.");
                return interfaceDashboard();
        }

        return "Transaction successful!";
    }

    private void deposit() {
        System.out.println("Enter amount to deposit: ");
        double amount = scanner.nextDouble();
        balance += amount;
        System.out.println("Deposit successful! New balance: $" + String.format("%.2f", balance));
    }

    private void withdraw() {
        System.out.println("Enter amount to withdraw: ");
        double amount = scanner.nextDouble();
        if (amount > balance) {
            System.out.println("Insufficient funds!");
        } else {
            balance -= amount;
            System.out.println("Withdrawal successful! New balance: $" + String.format("%.2f", balance));
        }
    }

    private void checkBalance() {
        System.out.println("Current balance: $" + String.format("%.2f", balance));
    }
}