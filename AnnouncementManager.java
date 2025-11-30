package BarangayManagementSystem;
import java.util.Scanner;
import java.util.concurrent.ForkJoinPool;
import java.time.LocalDate;
import java.util.LinkedList;
public class AnnouncementManager {
    private LinkedList<Announcement> announcementRecord = new LinkedList<>();
    private static AnnouncementManager single_instance = null;
     private LocalDate today = LocalDate.now();
      private int year = today.getYear();

	  	

        public void addAnnouncement(Scanner scan, String postedBy) {
			scan.nextLine();
            String announcementID = "BASD-" + year + "-" + String.format("%05d", newCountedAnnouncement()); 
            System.out.print("Enter Announcement Title: ");
            String announcementTitle = scan.nextLine();
            System.out.print("Enter Announcement Content: ");
            String announcementContent = scan.nextLine();
            String announcementDate = AnnouncementDate(scan);
			scan.nextLine();
            System.out.print("Enter Announcement Reason: ");
            String announcementReason = scan.nextLine();
            System.out.print("Enter Announcement Conclusion: ");
            String announcementConclusion = scan.nextLine();
            Announcement announcement = new Announcement(announcementID, announcementContent, announcementTitle, announcementDate, postedBy, announcementReason, announcementConclusion);
            announcementRecord.add(announcement);
        }

        public void deleteAnnouncement(Scanner scan) {
			scan.nextLine();
			System.out.print("Enter the announcement id that you want to delete: ");
			String deleteID = scan.nextLine();
			for (Announcement announcement : getAllAnnouncements()) {
				if (deleteID.equals(announcement.getAnnouncementID())) {
					getAllAnnouncements().remove(announcement);
					System.out.println("Announcement Deleted Successfully");
					break;
				}
			}
        }

        public void displayAllAnnouncement() {
			for (Announcement announcement : getAllAnnouncements()) {
				
				System.out.println(announcement + "\n");
			}
        }

        public void displayNewAnnouncement() {
			if (!getAllAnnouncements().isEmpty()) {
				System.out.println(getAllAnnouncements().getLast());
			}
			else {
				System.out.println("No Announcements Yet.");
			}
        }

        public void editAnnouncement(Scanner scan) {
			scan.nextLine();
            boolean isRunning = true;
			while (isRunning) {
				Announcement announcement = findAnnouncement(scan);
				if (announcement == null) {
					System.out.println("Invalid Input, Announcement ID does not Exist.");
					break;
				}
				System.out.println("=== Edit Announcement");
				System.out.println("1 - Date of Announcement");
				System.out.println("2 - Announcement Title");
				System.out.println("3 - Announcement Content");
				System.out.println("4 - Announcement Reason");
				System.out.println("5 - Announcement Conclusion");
				System.out.println("6 - Exit");
				int choose = scan.nextInt();
				switch (choose) {
					case 1 : 
						String editAnnouncementDate = AnnouncementDate(scan);
						announcement.setDateOfAnnouncement(editAnnouncementDate);
						break;
					case 2 :
						System.out.print("Edit Announcement Title: ");
						String editAnnouncementTitle = scan.nextLine();
						announcement.setAnnouncementTitle(editAnnouncementTitle);
						break;
					case 3 :
						System.out.print("Edit Announcement Content: ");
						String editAnnouncementContent = scan.nextLine();
						announcement.setAnnouncementContent(editAnnouncementContent);
						break;
					case 4 :
						System.out.print("Edit Announcement Reason: ");
						String editAnnouncementReason = scan.nextLine();
						announcement.setAnnouncementReason(editAnnouncementReason);
						break;
					case 5 :
						System.out.print("Edit Announcement Conclusion: ");
						String editAnnouncementConclusion = scan.nextLine();
						announcement.setAnnouncementConclusion(editAnnouncementConclusion);
						break;
					case 6 :
						isRunning = false;
						break;
					default :
						System.out.println("Invalid Input, Please only from the choices given.");
						break;
				}
			}
        }


        public int newCountedAnnouncement() {
            int totalAnnouncements = 0;
            for (Announcement announcement : getAllAnnouncements()) {
             totalAnnouncements++;   
            }
            totalAnnouncements++;
            return totalAnnouncements;
        }

		public Announcement findAnnouncement (Scanner scan) {
			System.out.print("Enter the Announcement ID: ");
			String findAnnouncement = scan.nextLine();
			for (Announcement announcement : getAllAnnouncements()) {
				if (findAnnouncement.equals(announcement.getAnnouncementID())) {
					return announcement;
				}
			}
			return null;
		}

    public static synchronized AnnouncementManager getInstance() {
        if (single_instance == null) {
            single_instance = new AnnouncementManager();
        }
        return single_instance;
    }

    public LinkedList<Announcement> getAllAnnouncements() {
        return announcementRecord;
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
