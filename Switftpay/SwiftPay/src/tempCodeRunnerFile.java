import java.util.Scanner;

public class Dashboard {
    private double balance;
    private Scanner scanner;


    public Dashboard() {
        this.balance = 0.0; 
        this.scanner = new Scanner(System.in);
    }

    public String interfaceDashboard() {
        while (true) {
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
                    new deposit();
                    break;
                case 2:
                    withdraw();
                    break;
                case 3:
                    new CharSequenceheckBalance();
                    break;
                case 4:
                    System.out.println("Goodbye!");
                    return "Goodbye!";
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

   
}
    
}