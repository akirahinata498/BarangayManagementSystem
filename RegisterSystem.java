package BarangayManagementSystem;
import java.util.Scanner;
public abstract class RegisterSystem<T extends Users<T>, M extends Menu> extends Authentication<T> {
  protected UsersManager<T> userManager;

    public RegisterSystem(UsersManager<T> userManager) {
        this.userManager = userManager;
    }

    public T registerUser(Scanner scan, T userRegister, String role) {
        boolean isRunning = true;
        while (isRunning) {
        System.out.print("Enter your username: ");
        userRegister.setUsername(scan.nextLine());
        userRegister.setEmail(validateEmail(scan)); 
        userRegister.setPassword(validatePassword(scan));
        System.out.print("Enter your district: ");
        userRegister.setDistrict(scan.nextLine());
        }
        return userRegister;
    }

    public void saveUser(Scanner scan, T registeredUser, M redirectMenu) {
     
        userManager.addUser(registeredUser);
        redirectMenu.processMenu(scan);
    }

    // 	public  String userInfoReturn(Users user) {
    //     return "Name=" + user.getUserName() +
    //            ", Password=" + user.getPassword() +
    //            ", Birthday=" + user.getBirthday() +
    //            ", Age=" + user.getAge() +
    //            ", Email=" + user.getEmail() +
    //            ", Number=" + user.getNumber() +
    //            ", Address=" + user.getAddress() +
    //            ", Gender=" + user.getGender() +
    //            ", Campus=" + user.getCampus();
    // }
	
}
