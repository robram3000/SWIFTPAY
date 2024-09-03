import java.util.Scanner;

import Database.Authentication;
import Database.DataBase;

public class LogIn extends DataBase {

    public String userInterface() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Login Interface");

        System.out.print("Enter Phone Number: ");
        String enteredPhone = scanner.nextLine();

        if (enteredPhone.length() != 11) {
            System.out.println("Please Check your Phone number");
            return userInterface();
        }

        System.out.print("Enter PIN: ");
        String enteredPin = scanner.nextLine();

        scanner.close();

        return numberofPin(enteredPin, enteredPhone);
    }

    public String numberofPin(String Pin, String Phone) {
        if (Pin.length() == 4) {
            Authentication auth = new Authentication("12345678911", "1234");
            if (auth.authenticatePinUser(Phone, Pin)) {
                System.out.println("Login successful!");
                return "Login successful!";
            } else {
                System.out.println("Invalid phone number or PIN. Please try again.");
                return "Invalid phone number or PIN. Please try again.";
            }
        } else {
            System.out.println("Please try again, the PIN must be 4 characters long.");
            return userInterface();
        }
    }

    public static void main(String[] args) {
        LogIn login = new LogIn();
        login.userInterface();
    }
}