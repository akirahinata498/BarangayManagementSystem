package BarangayManagementSystem;

import java.util.Scanner;

public class AdminRegister extends RegisterSystem<Admin, AdminMenu>{


        public void registerUser(Scanner scan, Admin userRegister, String role) {
            super.registerUser(scan, userRegister, role);
            System.out.println("Test for password are " + userRegister.getPassword());
            userRegister.setAccessLevel("Admin");
            AdminMenu adminMenu = new AdminMenu();
            saveUser(scan, userRegister, adminMenu);
    }

}
