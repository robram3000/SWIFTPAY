import java.util.Scanner;

import Database.Authentication;
import Database.DataBase;

public class LogIn extends DataBase {

    public void userInterface() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Login Interface\n");
        System.out.println("1. Login");
        System.out.println("2. Register Account");
        System.out.println("Choose an option:");

        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline left-over from nextInt()

        switch(choice) {
            case 1:
                System.out.print("Enter Phone Number (11 digits): ");
                String enteredPhone = scanner.nextLine();

                if (enteredPhone.length() != 11) {
                    System.out.println("Invalid phone number. Please enter a number with 11 digits.");
                } else {
                    System.out.print("Enter your 4-digit PIN: ");
                    String enteredPin = scanner.nextLine();
                    numberofPin(enteredPin, enteredPhone);
                }
                break;

            case 2:
                System.out.println("Register Account:");
                System.out.print("Enter Your Phone Number (11 digits): ");
                String registerPhoneNumber = scanner.nextLine();

                System.out.print("Enter Your Full Name: ");
                String registerFullName = scanner.nextLine();

                System.out.print("Enter Your 4-digit PIN: ");
                String registerPin = scanner.nextLine();

                if (registerPhoneNumber.length() != 11 || registerPin.length() != 4) {
                    System.out.println("Registration failed. Ensure phone number is 11 digits and PIN is 4 digits.");
                } else {
                    // You can add the code here to save the registration details.
                    System.out.println("Registration successful!");
                }
                break;

            default:
                System.out.println("Invalid choice. Please choose 1 or 2.");
        }

        scanner.close();
    }

    public String numberofPin(String pin, String phone) {
        if (pin.length() == 4) {
            Authentication auth = new Authentication("12345678911", "1234"); // This should ideally be dynamic
            if (auth.authenticatePinUser(phone, pin)) {
                System.out.println("Login successful!");
                return "Login successful!";
            } else {
                System.out.println("Invalid phone number or PIN. Please try again.");
                return "Invalid phone number or PIN. Please try again.";
            }
        } else {
            System.out.println("Please try again, the PIN must be 4 characters long.");
            return "Invalid PIN length.";
        }
    }

    public static void main(String[] args) {
        LogIn login = new LogIn();
        login.userInterface();
    }
}
