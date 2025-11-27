package BarangayManagementSystem;
import java.util.Scanner;
public class UserAccountManagement<T extends Users> {
    
    private Admin admin;
    private Residents resident;
    private AdminRegister adminRegister;
    private ResidentRegister residentRegister;
    private T usersInfo;
    private UsersManager userManager;
    UserAccountManagement(T usersInfo) {
        this.userManager = UsersManager.getInstance();
        this.usersInfo = usersInfo;
        admin = new Admin();
        resident = new Residents();
    }

        public void chooseUserToManage(Scanner scan) {
            boolean isRunning = true;
            while (isRunning) {
           System.out.println("Enter your choice");
           System.out.println("1 - Manage Admin");
           System.out.println("2 - Manage Residents");   
           System.out.println("3 - Exit");
           int choose = scan.nextInt();
           switch (choose) {
            case 1 -> manageAdmin(scan);
            case 2 -> manageResidents(scan);
            case 3 -> isRunning = false;
            default -> System.out.println("Please enter only from the choices given");
           }
            }
        }   
        private void manageAdmin(Scanner scan) {
            boolean isRunning = true;
            while (isRunning) {
            System.out.println("Enter your choice");
            System.out.println("1 - Add Admin");
            System.out.println("2 - Edit Admin");
            System.out.println("3 - Delete Admin");
            System.out.println("4 - View All Admin");
            System.out.println("4 - Exit");   
            int userChoice = scan.nextInt();
                switch (userChoice) {
                    case 1 -> adminRegister.registerUser(scan, admin, "Admin");
                    case 2 -> userManager.editProfile(scan,  "Admin");
                    case 3 -> userManager.deleteProfile(scan, "Admin");
                    case 5 -> isRunning = false;
                    default -> System.out.println("Invalid Input. Please try again");
                }
            }
        }

        private void manageResidents(Scanner scan) {

              boolean isRunning = true;
            while (isRunning) {
            System.out.println("Enter your choice");
            System.out.println("1 - Add Residents");
            System.out.println("2 - Edit Residents");
            System.out.println("3 - Delete Residents");
            System.out.println("4 - View All Residents");
            System.out.println("5 - Exit");
            int userChoice = scan.nextInt();
            switch (userChoice) {
                case 1 -> residentRegister.registerUser(scan, resident, "Resident");
                case 2 -> userManager.editProfile(scan,  "Resident");
                case 3 -> userManager.deleteProfile(scan, "Resident");
                case 5 -> isRunning = false;
                default -> System.out.println("Invalid Input. Please try again");
            }
            }
        }



}
