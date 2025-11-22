package BarangayManagementSystem;
import java.util.InputMismatchException;
import java.util.Scanner;
public class LandingMenu implements Menu{

    @Override
    public void displayMenu() {
               System.out.println("****************************************");
        System.out.println(" Welcome to Barangay Management System");
         System.out.println("****************************************");
        System.out.println("1 - Login");
        System.out.println("2 - Register");
        System.out.println("3 - Exit");
    }

    @Override
    public void handleInputs(Scanner scan) {

        try {
            int choose = scan.nextInt();
            LoginMenu loginMenu = new LoginMenu();
            RegisterMenu registerMenu = new RegisterMenu();
            switch (choose) {
                // case 1 -> 
                // case 2 ->
                default:
            }
        }catch(InputMismatchException e) {
            e.printStackTrace();
        }
    }
}
