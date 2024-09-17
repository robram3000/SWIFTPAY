import java.util.Scanner;

import Database.Authentication;
import Database.DataBase;

public class LogIn extends DataBase {

    public void userInterface() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Login Interface\n");


        System.out.print("Please enter something");
        int Choose = scanner.nextInt();

        switch(Choose)
        {
            case 1:
                System.out.print("Enter Phone Number: ");
                String enteredPhone = scanner.nextLine();

                if (enteredPhone.length() != 11) {
                    System.out.println("Please Check your Phone number");
                }
                scanner.close();

                break;
            case 2:
                System.out.print("Register Account Bank\n");

                System.out.print("Enter Your PhoneNumber: ");
                int registerPhonenumber = scanner.nextInt();

                System.out.print("Enter Your Fullname: ");
                String registerFullname = scanner.toString();

                System.out.print("Enter Your PhoneNumber");
                int registerPin = scanner.nextInt();

                break;
            default:

        }


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

        }
    }

    public static void main(String[] args) {
        LogIn login = new LogIn();
        login.userInterface();
    }
}