package BarangayManagementSystem;
import java.util.LinkedList;
import java.util.Scanner;
public class UserManager<T extends Users<T>> extends Users<T> {
             private LinkedList<T> user = new LinkedList<>();   
        //so dito ko isasave yung user sa linkedlist tas dito ko nadin imanage si display 
        public void processRegistration(T userDataRegistration) {

        }

         public void editProfile(Scanner scan) {
            
         }

         public void deleteProfile(Scanner scan) {
            
         }


}