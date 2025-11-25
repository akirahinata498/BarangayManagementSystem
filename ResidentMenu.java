package BarangayManagementSystem;

import java.util.Scanner;

public class ResidentMenu extends BaseMenu implements MenuValidation<Residents>{
    private UsersManager usersManager;
    private Residents userInfo;
    private boolean userValidation;
    ResidentMenu() {
        this.usersManager = UsersManager.getInstance();
    }
    @Override
    public void displayMenu() {
        
       System.out.println("=== Welcome " + userInfo.getUsername() + " ===");
       System.out.println("1 - print test ");
       System.out.println("2 - practice");
       System.out.println("3 - practice");
       System.out.println("4 - Exit");
    }   

    @Override
    public boolean chooseMenu(Scanner scan) {
        int userChoice = scan.nextInt();
        switch (userChoice) {
            
            case  4 -> {return false;}
            default -> System.out.println("Please enter a proper input");
        }
        return true;
    }

    @Override
    public void processMenu(Scanner scan) {
        boolean isRunning = true;
        while (isRunning) {
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
    public void setUserInfo(Residents userInfo) {
       this.userInfo = userInfo;
    }
    @Override
    public Residents getUserInfo() {
        return userInfo;
    }
    public boolean isUserValidated() {
        return userValidation;
    }
    public void setUserValidation(boolean userValidation) {
        this.userValidation = userValidation;
    }
    @Override
    public void CheckUserAuth(Residents userCheck) {
        System.out.println("This is a test");
        for (Users users : usersManager.getAllUsers()) {
            if (userCheck.getUsername().equals(users.getUsername()) && userCheck.getPassword().equals(users.getPassword())) {
                System.out.println("Test cgeck");
                setUserInfo((Residents) users);
                setUserValidation(true);
            }
        }   
    }
    @Override
    public boolean CheckUserAuth(String username, String password) {
        System.out.println("Thid is a test");
        for (Users users : usersManager.getAllUsers()) {
            if (users.getUsername().equals(username) && users.getPassword().equals(password)) {
                setUserInfo((Residents) users);
                setUserValidation(true);
                return true;
            }
        }
        return false;
    }
}
