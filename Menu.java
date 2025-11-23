package BarangayManagementSystem;
import java.util.Scanner;
public interface Menu {
    void displayMenu();
    void chooseMenu(Scanner scan);
    default void processMenu(Scanner scan) {
        displayMenu();
        chooseMenu(scan);
    }
}
