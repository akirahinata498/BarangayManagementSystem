package BarangayManagementSystem;
import java.util.Scanner;
public abstract class RegisterSystem<T extends Users<T>> extends Authentication<T> {

    
    public void saveUser() {

    }

    public void registerUser(Scanner scan, T userRegister) {
        System.out.print("Enter your name: ");
        
    }


}
