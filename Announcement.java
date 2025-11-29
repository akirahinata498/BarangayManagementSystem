package BarangayManagementSystem;

public class Announcement {
    private String announcementID;
    private String announcementContent;
    private String announcementTitle;
    private String dateOfAnnouncement;
    private String postedBy;
    private String announcementReason;
    private String announcementConclusion;
    Announcement() {
    }

    Announcement(String announcementID, String announcementContent, String announcementTitle, String dateOfAnnouncement, String postedBy, String announcementReason, String announcementConclusion) {
        this.announcementID = announcementID;
        this.announcementContent = announcementContent;
        this.announcementTitle = announcementTitle;
        this.dateOfAnnouncement = dateOfAnnouncement;
        this.postedBy = postedBy;
        this.announcementReason = announcementReason;
        this.announcementConclusion = announcementConclusion;
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
public String getAnnouncementReason() {
    return announcementReason;
}
public String getAnnouncementConclusion() {
    return announcementConclusion;
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
public void setAnnouncementReason(String announcementReason) {
    this.announcementReason = announcementReason;
}
public void setAnnouncementConclusion(String announcementConclusion) {
    this.announcementConclusion = announcementConclusion;
}


@Override
public String toString(){ 
    return "=== Barangay San Dimas Officcial Announcement ===" + "\n" +
            "Dated Posted: " + getDateOfAnnouncement() + "\n" +
            "Posted By: " + getPostedBy() + "\n\n\n" +
            "Subject: " + getAnnouncementTitle() + "\n" +
            "Dear Citizens of San Dimas," + "\n\n\n" +
            wrapText(getAnnouncementContent(), 50) + "\n\n\n" +
            wrapText(getAnnouncementReason(), 50) + "\n\n\n" + 
            wrapText(getAnnouncementConclusion(), 50) + "\n\n\n" +
            "Thank You";
}

private String wrapText(String text, int maxWidth) {
    StringBuilder result = new StringBuilder();
    int index = 0;

    while (index < text.length()) {
        int end = Math.min(index + maxWidth, text.length());

        // If end is not end of text and the next char is not whitespace,
        // move backwards to last whitespace
        if (end < text.length() && text.charAt(end) != ' ') {
            int lastSpace = text.lastIndexOf(' ', end);
            if (lastSpace > index) {
                end = lastSpace;
            }
        }

        result.append(text, index, end).append("\n");
        index = end + 1; // skip the space after line break
    }

    return result.toString();
}


}
