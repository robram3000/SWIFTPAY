//import java.util.Scanner;
//
//public class Dashboard  extends database{
//    private double balance;
//    private Scanner scanner;
//
//    public enum Options {
//        DEPOSIT,
//        WITHDRAW,
//        CHECK_BALANCE,
//        EXIT
//    }
//
//    public Dashboard() {
//        this.balance = 0.0;
//        this.scanner = new Scanner(System.in);
//    }
//
//    public String interfaceDashboard() {
//        while (true) {
//            System.out.println("SUMMARY DASHBOARD ACCOUNT ");
//            System.out.println("Balance: $" + String.format("%.2f", balance));
//            System.out.println();
//
//            System.out.println("Choose an option:");
//            for (Options option : Options.values()) {
//                System.out.println((option.ordinal() + 1) + ". " + option);
//            }
//
//            Options choice = Options.values()[scanner.nextInt() - 1];
//
//            switch (choice) {
//                case DEPOSIT:
//                    deposit();
//                    break;
//                case WITHDRAW:
//                    withdraw();
//                    break;
//                case CHECK_BALANCE:
//                    checkBalance();
//                    break;
//                case EXIT:
//                    System.out.println("Goodbye!");
//                    return "Goodbye!";
//            }
//        }
//    }
//
//    private void deposit() {
//        System.out.println("Enter amount to deposit: ");
//        double amount = scanner.nextDouble();
//        balance += amount;
//        System.out.println("Deposit successful! New balance: $" + String.format("%.2f", balance));
//    }
//
//    private void withdraw() {
//        System.out.println("Enter amount to withdraw: ");
//        double amount = scanner.nextDouble();
//        if (amount > balance) {
//            System.out.println("Insufficient funds!");
//        } else {
//            balance -= amount;
//            System.out.println("Withdrawal successful! New balance: $" + String.format("%.2f", balance));
//        }
//    }
//
//    private void checkBalance() {
//        System.out.println("Current balance: $" + String.format("%.2f", balance));
//    }
//}