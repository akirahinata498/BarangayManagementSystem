package BarangayManagementSystem;

import java.util.Scanner;

public class AdminRegister<T extends Users<T>> extends RegisterSystem<T>{
        public void registerUser(Scanner scan, Admin<T> userRegister) {
        System.out.print("Enter your name: ");
    }

}
