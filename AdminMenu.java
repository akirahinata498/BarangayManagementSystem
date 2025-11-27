package BarangayManagementSystem;

import java.util.Scanner;

public class AdminMenu extends BaseMenu implements MenuValidation<Admin>{
    private UsersManager usersManager;
    private Admin userInfo;
    private boolean userValidation;
    private UserAccountManagement<Admin> userManagement;
    private PayrollRecord payrollRecord;
    private ProjectBudgetRecord projectBudgetRecord;
    private MaintenanceRecord maintenanceRecord;
    private ProcurementRecord procurementRecord;
    AdminMenu() {
        this.usersManager = UsersManager.getInstance();
        this.userManagement = new UserAccountManagement<>(getUserInfo());
        // admin = usersManager.
    }
    @Override
    public void displayMenu() {
           System.out.println("=== Welcome " + userInfo.getUsername() + " ===");
            System.out.println("1 - Resident Management");
            System.out.println("2 - Certificate Management");
            System.out.println("3 - Announcement Management");
            System.out.println("4 - Incident Report Management");
            System.out.println("5 - User & Account Management");
            System.out.println("6 - System Logs");
            System.out.println("7 - System Settings");
            System.out.println("8 - Financial Reports");
            System.out.println("9 - Logout");
    }

    @Override
    public boolean chooseMenu(Scanner scan) {
      int userData = scan.nextInt();
      switch (userData) {
        case 5 -> userManagement.chooseUserToManage(scan);
        case 8 -> ManageFinancialRecording(scan);
        case 9 -> {return isuserLogout(scan);}
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
    
        for (Users users : usersManager.getAllUsers()) {
            if (userCheck.getUsername().equals(users.getUsername()) && userCheck.getPassword().equals(users.getPassword())) {
                 setUserValidation(true);
                setUserInfo((Admin) users);
            }
        }
    }

    private void ManageFinancialRecording(Scanner scan) {
        boolean isRunning = true;
        while (isRunning) {
            System.out.println("=== Enter Record ===");
            System.out.println("1 - Payroll Record");
            System.out.println("2 - Maintenance Record");
            System.out.println("3 - Project Budget Record");
            System.out.println("4 - Procurement Record");
            System.out.println("5 - Exit");
            int chooseRecprd = scan.nextInt();
            switch (chooseRecprd) {
                case 1 -> payrollRecord.chooseActions(scan, "Payroll");
                case 2 -> maintenanceRecord.chooseActions(scan, "Maintenance");
                case 3 -> projectBudgetRecord.chooseActions(scan, "Project");
                case 4 -> procurementRecord.chooseActions(scan, "Procurement");
                case 5 -> isRunning = false;
                default -> System.out.println("Invalid Input, Please enter a proper input");
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
    @Override
    public boolean CheckUserAuth(String username, String password) {
      
        for (Users users : usersManager.getAllUsers()) {
            if (users.getUsername().equals(username) && users.getPassword().equals(password)) {
                setUserInfo((Admin) users);
                setUserValidation(true);
                return true;
            }
        }
        return false;
    }
    
}
