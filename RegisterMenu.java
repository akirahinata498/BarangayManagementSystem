package BarangayManagementSystem;

import java.util.Scanner;

public class RegisterMenu implements Menu {

    @Override
    public void displayMenu() {
       System.out.println("=== Register ===");
       System.out.println("1 - Admin");
       System.out.println("2 - Resident");
       System.out.println("3 - Exit");

    }

    @Override
    public void chooseMenu(Scanner scan) {
        int userInputs = scan.nextInt();
        AdminRegister<Admin> adminRegister = new AdminRegister<>(null);
        ResidentRegister<Residents> residentRegister = new ResidentRegister<>(null);
        // switch (userInputs) {
           
        // }
    }




    
}
