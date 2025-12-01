package BarangayManagementSystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class CertificateManager {
    private CertificateRequestStorage certificateRequestStorage;
    

    CertificateManager() {
        this.certificateRequestStorage = CertificateRequestStorage.getInstance();
    }


    public void newRequest(Scanner scan, String fname, String mname, String lname) {
        System.out.println("=== Certificate Request System ===");
        System.out.println("Enter your Purpose");
        String purpose = scan.nextLine();
        String fullName = fname + " " + mname + " " + "lname";
        String certificateType = scan.nextLine();
        certificateRequestStorage.createRequest(fullName, certificateType, purpose);
        System.out.println("\nRequest Created Successfully");
    }

    public void residentViewCertificate(String fname, String mname, String lname) {
        String fullName = fname + " " + mname + " " + lname;
        List<CertificateRequest> myRequests = certificateRequestStorage.findRequestsByName(fullName);
        if (myRequests.isEmpty()) System.out.println("No requests found for " + fullName);
        else {
            System.out.println("\n--- YOUR REQUESTS ---");
            for (CertificateRequest r : myRequests) System.out.println(r);
        }
    }




}