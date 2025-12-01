package BarangayManagementSystem;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CertificateRequest {
    private int id;
    private String name;
    private String certificateType;
    private String purpose;
    private LocalDateTime dateCreated;
    private String status;

    public CertificateRequest(int id, String name, String certificateType, String purpose) {
        this.id = id;
        this.name = name;
        this.certificateType = certificateType;
        this.purpose = purpose;
        this.dateCreated = LocalDateTime.now();
        this.status = "Pending Approval";   
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getCertificateType() { return certificateType; }
    public String getPurpose() { return purpose; }
    public String getStatus() { return status; }
    public String getDateCreated() {
        return dateCreated.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
    }

   
    public String toString() {
        return "\nID: " + id +
               "\nName: " + name +
               "\nCertificate Type: " + certificateType +
               "\nPurpose: " + purpose +
               "\nDate Created: " + getDateCreated() +
               "\nStatus: " + status + "\n";
    }
}