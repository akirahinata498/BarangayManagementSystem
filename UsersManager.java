package BarangayManagementSystem;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.LinkedList;
import java.util.Scanner;
public class UsersManager {
    private Residents resident;
    private Admin admin;
    
    private LinkedList<Users> usersData = new LinkedList<>();
    private static UsersManager single_instance = null;

    public void loginUser(Scanner scan) {
        scan.nextLine();
        boolean isRunning = true; 
        boolean isLogin = false;
        String userRole = "";
        while (isRunning) {
        System.out.println("=== Login ===");
        System.out.print("Enter your Username: ");
        String username = scan.nextLine();
        System.out.print("Enter your Password: ");
        String password = hashPassword(scan.nextLine());
        
        for (Users users : getAllUsers()) {
            System.out.println("The map one are "  + users.getUsername());
            System.out.println("The input username are " + username);
            System.out.println("The map one for password are " + users.getPassword());
            System.out.println("The input password are " + password);
            if (username.equals(users.getUsername()) && password.equals(users.getPassword())) {
                System.out.println("Login Success");
                isLogin = true;
                userRole = users.getRole();
                System.out.println("The role are " + users.getRole());
                if (users.getRole().equals("Resident")) {
                resident = (Residents) users;
                ResidentMenu residentMenu = new ResidentMenu();
                    residentMenu.CheckUserAuth(username, password);
                    residentMenu.processMenu(scan);
                }
                else if (users.getRole().equals("Admin")) {
                    admin = (Admin) users;
                    AdminMenu adminMenu = new AdminMenu();
                     adminMenu.CheckUserAuth(username, password);
                    adminMenu.processMenu(scan);
                }
                break;
            }
            }

        }
    } 
    public void addUser(Users userRegister) {
        usersData.add(userRegister);
    }

    public void deleteProfile(Scanner scan) {

    }

    public void editProfile(Scanner scan) {

    }

    public static synchronized UsersManager getInstance() {
        if (single_instance == null) {
            single_instance = new UsersManager();
        }
        return single_instance;
    }

    public LinkedList<Users> getAllUsers() {
        return usersData;
    }
        public String hashPassword(String password) { 
        		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			byte[] encodedhash = digest.digest(password.getBytes());
			StringBuilder hexstring = new StringBuilder();
			for (byte b : encodedhash) {
				String hex = Integer.toHexString(0xff & b);
				if (hex.length() == 1 ) hexstring.append('0');
				hexstring.append(hex);
			}
			return hexstring.toString();
		}catch (NoSuchAlgorithmException e) {
			throw new RuntimeException("Error: SHA-256 Algorithm not found", e);
		}
    }
}
