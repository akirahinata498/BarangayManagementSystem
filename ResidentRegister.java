package BarangayManagementSystem;

import java.util.LinkedList;
import java.util.Scanner;

public class ResidentRegister<T extends Users<Residents>> extends RegisterSystem<Residents, ResidentMenu>{
    
    // private String completeAddress; //in the address we can create an address object here for the user
    // private int age;
    // private String gender;
    // private String fname;
    // private String mname;
    // private String lname;
    // private String contactNumber;
    // private String civilStatus;
    // private String dateOfBirth;

    public ResidentRegister(UsersManager<Residents> userManager) {
        super(userManager);
    }

    public Residents registerUser(Scanner scan, Residents userRegister, String role) {
        super.registerUser(scan, userRegister, role);
        System.out.print("Enter your complete address: ");
        userRegister.setCompleteAddress(scan.nextLine());
        userRegister.setAge(validateAge(scan));
        userRegister.setGender(validateGender(scan));
        System.out.print("Enter your First Name: ");
        userRegister.setFname(scan.nextLine());
        System.out.print("Enter your Middle Name: ");
        userRegister.setMname(scan.nextLine());
        System.out.print("Enter your Last Name: ");
        userRegister.setLname(scan.nextLine());
        userRegister.setContactNumber(validateContactNumber(scan));
        userRegister.setDateOfBirth(validateDateOfBirth(scan));
        return userRegister;
    }

    public String validateGender(Scanner scan) {
        String gender = "";
        boolean isRunning = true;
        while (isRunning) {
         System.out.print("Enter your gender: ");
            gender = scan.nextLine();
            if (gender.equalsIgnoreCase("male") || gender.equalsIgnoreCase("m")) {
                gender = "Male";
                isRunning = false;
            }
            else if (gender.equalsIgnoreCase("female") || gender.equalsIgnoreCase("f")) {
                gender = "Female";
                isRunning = false;
            }
            else {
                System.out.println("Please entera a proper gender");
            }
        }
        return gender;
    }
    public String validateContactNumber(Scanner scan) {
        String contactNumber = "";
        boolean isRunning = true;
        while (isRunning) {
            System.out.print("Enter your Contact Number: ");
            contactNumber = scan.nextLine();
            // (Number.matches("^09\\d{9}$") || Number.matches("^\\+639\\d{9}$")
            if (!contactNumber.matches("^09\\d{9}$") || contactNumber.matches("^\\+639\\d{9}$")) {
                System.out.println("Invalid Philipphine Number Format, Please try again");
            }
            else {
                isRunning = false;
            }
        }
        return contactNumber;
    }

    public int validateAge(Scanner scan) {
        int age = 0;
        boolean isRunning = true;
        while (isRunning) {
         System.out.print("Enter your age: ");
          age = scan.nextInt();
        if (age <= 17 || age >= 150) {
            System.out.print("Please enter a proper age: ");
        }
        else {
            isRunning = false;
        }
        }
        return age;
    }

    public String validateCivilStatus(Scanner scan) {
        String civilStatus = "";
        boolean isRunning = true;
        while (isRunning) {
            System.out.println("S - Single");
            System.out.println("M - Married");
            System.out.println("D - Divorced");
            System.out.println("W - Widowed");
            System.out.println("E - Seperated");
            System.out.println("C - Civil Partnership");
            System.out.print("Enter your Civil Status: ");
            String civilStatusChoice = scan.nextLine();
            switch (civilStatusChoice) {
                case "S" -> civilStatus = "Single";
                case "M" -> civilStatus = "Married";
                case "D" -> civilStatus = "Divorced";
                case "W" -> civilStatus = "Widowed";
                case "E" -> civilStatus = "Seperated";
                case "C" -> civilStatus = "Civil Partnership";
                default ->{ 
                    System.out.println("Please enter only from the choices given");
                    continue;
                }
            }
        }
        return civilStatus;
    }

	public String validateDateOfBirth(Scanner scan) {
		boolean isRunning = true;
		String month = "";
		String day = "";
		String year = "";
		while (isRunning) {
			System.out.println("Enter the month of your birthday E.G 1 for january");

			try {
			byte monthchoose = scan.nextByte();
			 month= "";
			switch (monthchoose) {
			case 1 -> month = "January";
			case 2 -> month = "February";
			case 3 -> month = "March";
			case 4 -> month = "April";
			case 5 -> month = "May";
			case 6 -> month = "June";
			case 7 -> month = "July";
			case 8 -> month = "August";
			case 9 -> month = "September";
			case 10 -> month = "October";
			case 11 -> month = "November";
			case 12 -> month = "December";
			default -> {
				System.out.println("Please choose something properly");
				continue;
				}
			}
			System.out.println("Please choose the day of your birth");
			byte dayscan = scan.nextByte();
			 day = "";
			if (dayscan <= 0 || dayscan > 31) {
				System.out.println("Please enter a proper date");
				continue;
			}
			else {
				day = Integer.toString(dayscan);
			}
			System.out.println("Please enter your birth year");
			int yearscan = scan.nextInt();
			 year = "";
			if (yearscan < 1950 || yearscan > 2007) {
				System.out.println("Please enter a proper birthyear");
				continue;
			}
			else {
				year = Integer.toString(yearscan);
			}
			}catch (Exception e) {
				System.out.println("Please enter a proper answer");
				scan.nextLine();
				continue;
			}
			isRunning = false;
		}
	
	
	return month + "-" + day + "-" +  year;
	}
}
