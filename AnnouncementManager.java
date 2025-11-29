package BarangayManagementSystem;
import java.util.Scanner;
import java.util.concurrent.ForkJoinPool;
import java.time.LocalDate;
import java.util.LinkedList;
public class AnnouncementManager {
    private LinkedList<Announcement> usersData = new LinkedList<>();
    private static AnnouncementManager single_instance = null;
     private LocalDate today = LocalDate.now();
      private int year = today.getYear();


        public void addAnnouncement(Scanner scan, String postedBy) {
            String announcementID = "BASD-" + year + "-" + String.format("%05d", newCountedAnnouncement()); 
            System.out.print("Enter Announcement Title: ");
            String announcementTitle = scan.nextLine();
            System.out.print("Enter Announcement Content: ");
            String announcementContent = scan.nextLine();
            String announcementDate = AnnouncementDate(scan);
            System.out.print("Enter Announcement Reason: ");
            String announcementReason = scan.nextLine();
            System.out.print("Enter Announcement Conclusion: ");
            String announcementConclusion = scan.nextLine();
            Announcement announcement = new Announcement(announcementID, announcementContent, announcementTitle, announcementDate, postedBy, announcementReason, announcementConclusion);
            System.out.println("Announcement Test: " + announcement);
            usersData.add(announcement);
        }

        public void deleteAnnouncement(Scanner scan) {

        }

        public void displayAllAnnouncement() {

        }

        public void displayNewAnnouncement() {

        }

        public void editAnnouncement(Scanner scan) {
            
        }


        public int newCountedAnnouncement() {
            int totalAnnouncements = 0;
            for (Announcement announcement : getAllAnnouncements()) {
             totalAnnouncements++;   
            }
            totalAnnouncements++;
            return totalAnnouncements;
        }

    public static synchronized AnnouncementManager getInstance() {
        if (single_instance == null) {
            single_instance = new AnnouncementManager();
        }
        return single_instance;
    }

    public LinkedList<Announcement> getAllAnnouncements() {
        return usersData;
    }


    	public String AnnouncementDate(Scanner scan) {
		boolean isRunning = true;
		String month = "";
		String day = "";
		String year = "";
		while (isRunning) {
			System.out.println("Enter the month of Announcement E.G 1 for january");

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
			System.out.println("Enter the date of Announcement");
			byte dayscan = scan.nextByte();
			 day = "";
			if (dayscan <= 0 || dayscan > 31) {
				System.out.println("Please enter a proper date");
				continue;
			}
			else {
				day = Integer.toString(dayscan);
			}
			System.out.println("Enter year of Announcement");
			int yearscan = scan.nextInt();
			 year = "";
			if (yearscan < 1950 || yearscan > 2007) {
				System.out.println("Please enter a proper year");
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
