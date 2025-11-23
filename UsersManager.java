package BarangayManagementSystem;

import java.util.LinkedList;
import java.util.Scanner;
public class UsersManager<T extends Users<T>> {
    private LinkedList<T> usersData = new LinkedList<>();

    public void addUser(T userRegister) {
        usersData.add(userRegister);
    }

    public void deleteProfile(Scanner scan) {

    }

    public void editProfile(Scanner scan) {

    }
}
