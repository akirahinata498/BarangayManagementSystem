package BarangayManagementSystem;


import java.util.Scanner;

public abstract class Authentication<T extends Users> extends Users {
    

    public Authentication(){ 

    }
    public void login(Scanner scan) {
        
    }


    public String validatePassword(Scanner scan) {
		boolean isRunning = true;
		String password = "";
		while (isRunning) {
			System.out.println("Enter your password: ");
			password = scan.nextLine();
			if (!password.matches("[a-zA-Z0-9]+@[0-9]+")) {
				System.out.println("Please enter a proper password format");
			}
			else {
				isRunning = false;
			}
		}
        return password;
    }
    public String validateEmail(Scanner scan) {
		boolean isRunning = true;
		String email = "";
		while (isRunning) {
			System.out.println("Enter your email: ");
			email = scan.nextLine();
			if (!email.matches("^[a-zA-Z0-9]+@[a-zA-Z0-9]+mail\\.com$")) {
				System.out.println("Please enter a proper email format");
			}
			else {
				isRunning = false;
			}
		}
        return email;
    }
}
