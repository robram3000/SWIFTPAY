import java.util.Scanner;

import Database.Authentication;
import Database.DataBase;

public class LogIn extends DataBase {

    private Scanner scanner = new Scanner(System.in);

    public void userInterface() {
        System.out.println("Welcome to the Login Interface\n");
        System.out.println("1. Login");
        System.out.println("2. Register Account");
        System.out.print("Choose an option: ");

        int choice = getValidChoice();

        switch (choice) {
            case 1:
                handleLogin();
                break;

            case 2:
                handleRegistration();
                break;

            default:
                System.out.println("Invalid choice. Please restart and choose 1 or 2.");
        }
    }
    private void handleLogin() {
        String enteredPhone = getValidPhoneNumber("Enter Phone Number (11 digits): ");
        String enteredPin = getValidPin("Enter your 4-digit PIN: ");

        String loginStatus = numberofPin(enteredPin, enteredPhone);
        System.out.println(loginStatus);
    }
    private void handleRegistration() {
        System.out.println("Register Account:");

        String registerPhoneNumber = getValidPhoneNumber("Enter Your Phone Number (11 digits): ");
        System.out.print("Enter Your Full Name: ");
        String registerFullName = scanner.nextLine();
        String registerPin = getValidPin("Enter Your 4-digit PIN: ");


        boolean registrationSuccess = saveRegistration(registerPhoneNumber, registerFullName, registerPin);

        if (registrationSuccess) {
            System.out.println("Registration successful!");
        } else {
            System.out.println("Registration failed. Please try again.");
        }
    }
    private String getValidPhoneNumber(String prompt) {
        String phoneNumber;
        do {
            System.out.print(prompt);
            phoneNumber = scanner.nextLine();
            if (phoneNumber.length() != 11 || !phoneNumber.matches("\\d+")) {
                System.out.println("Invalid phone number. Please enter a number with 11 digits.");
            }
        } while (phoneNumber.length() != 11 || !phoneNumber.matches("\\d+"));
        return phoneNumber;
    }

    private String getValidPin(String prompt) {
        String pin;
        do {
            System.out.print(prompt);
            pin = scanner.nextLine();
            if (pin.length() != 4 || !pin.matches("\\d+")) {
                System.out.println("Invalid PIN. Please enter a 4-digit PIN.");
            }
        } while (pin.length() != 4 || !pin.matches("\\d+"));
        return pin;
    }

    public String numberofPin(String pin, String phone) {
        Authentication auth = new Authentication(phone, pin); 
        if (auth.authenticatePinUser(phone, pin)) {
            return "Login successful!";
        } else {
            return "Invalid phone number or PIN. Please try again.";
        }
    }


    private int getValidChoice() {
        int choice = -1;
        while (choice != 1 && choice != 2) {
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine(); 
            } else {
                System.out.println("Invalid input. Please enter 1 or 2.");
                scanner.next(); 
            }
        }
        return choice;
    }

    // Simulates saving registration details to a database
    private boolean saveRegistration(String phone, String fullName, String pin) {
        // Simulate a database save operation
        System.out.println("Saving registration details...");
        // In real implementation, you'd save to a database and return true/false based on success
        return true; // Assuming the save is successful
    }

    public static void main(String[] args) {
        LogIn login = new LogIn();
        login.userInterface();
    }
}
