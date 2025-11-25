package BarangayManagementSystem;

import java.util.LinkedList;
import java.util.Scanner;
public class UsersManager {
    private LinkedList<Users> usersData = new LinkedList<>();
    private static UsersManager single_instance = null;
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

}
