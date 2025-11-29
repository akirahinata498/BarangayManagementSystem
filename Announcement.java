package BarangayManagementSystem;

public class Announcement {
    private String announcementID;
    private String announcementContent;
    private String announcementTitle;
    private String dateOfAnnouncement;
    private String postedBy;

    Announcement() {
    }

//getters
public String getAnnouncementID() {
    return announcementID;
}

public String getAnnouncementContent() {
    return announcementContent;
}

public String getAnnouncementTitle() {
    return announcementTitle;
}

public String getDateOfAnnouncement() {
    return dateOfAnnouncement;
}

public String getPostedBy() {
    return postedBy;
}


//setters
public void setAnnouncementID(String announcementID) {
    this.announcementID = announcementID;
}
public void setAnnouncementContent(String announcementContent) {
    this.announcementContent = announcementContent;
}
public void setAnnouncementTitle(String annocementTitle) {
    this.announcementTitle = annocementTitle;
}
public void setDateOfAnnouncement(String dateOfAnnouncement) {
    this.dateOfAnnouncement = dateOfAnnouncement;
}
public void setPostedBy(String postedBy) {
    this.postedBy = postedBy;
}


// @Override
// public String toString(){ 
//     return "=== Barangay San Dimas Officcial Announcement ===" + "\n" +
//             "Dated Posted: " + getDateOfAnnouncement() + "\n" +
//             "Posted By: " + getPostedBy() + "\n" + "\n
//             "";
// }

}
