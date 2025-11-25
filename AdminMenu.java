package BarangayManagementSystem;

import java.util.Scanner;

public class AdminMenu extends BaseMenu implements MenuValidation<Admin>{
    private UsersManager usersManager;
    private Admin userInfo;
    private boolean userValidation;
    AdminMenu() {
        this.usersManager = UsersManager.getInstance();
        // admin = usersManager.
    }
    @Override
    public void displayMenu() {
           System.out.println("=== Welcome " + userInfo.getUsername() + " ===");
      System.out.println("1 - test1");
      System.out.println("2 - test2");
      System.out.println("3 - dasdadsa");
      System.out.println("3 - kndkand");
      System.out.println("4 - exit");
    }

    @Override
    public boolean chooseMenu(Scanner scan) {
      int userData = scan.nextInt();
      switch (userData) {
        case 4 -> {return true;}
        default -> System.out.println("Please enter a proper input");
      }
      return true;
    }

    @Override
    public void processMenu(Scanner scan) {
        boolean isRunning = true;
        while(isRunning) {
            if (isUserValidated() && userInfo != null) {
                displayMenu();
                isRunning = chooseMenu(scan);
            }
            else {
                System.out.println("User is not yet validated");
                isRunning = false;
            }
        }
    }

    @Override
    public void CheckUserAuth(Admin userCheck) {
        System.out.println("This is a test");
        for (Users users : usersManager.getAllUsers()) {
            if (userCheck.getUsername().equals(users.getUsername()) && userCheck.getPassword().equals(users.getPassword())) {
                System.out.println("Banzai");
                setUserInfo((Admin) users);
            }
        }
    }
    @Override
    public void setUserInfo(Admin userInfo) {
        this.userInfo = userInfo;
    }
    @Override
    public Admin getUserInfo() {
      return userInfo;
    }
    public boolean isUserValidated() {
        return userValidation;
    }
    public void setUserValidation(boolean userValidation) {
        this.userValidation = userValidation;
    }
    
}
