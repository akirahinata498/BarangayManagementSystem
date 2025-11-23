package BarangayManagementSystem;

import java.util.Scanner;

public class AdminRegister<T extends Users<Admin>> extends RegisterSystem<Admin, AdminMenu>{
        public AdminRegister(UsersManager<Admin> userManager) {
        super(userManager);

    }

        public void registerUser(Scanner scan, Admin userRegister) {
        System.out.print("Enter your name: ");
        
    }

}
