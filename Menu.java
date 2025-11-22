package BarangayManagementSystem;
import java.util.Scanner;
public interface Menu {
    void displayMenu();
    Menu chooseMenu(Scanner scan);
    void processMenu();
}
