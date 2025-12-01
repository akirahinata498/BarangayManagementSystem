package BarangayManagementSystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class CertificateManager {
    private CertificateRequestStorage certificateRequestStorage;
    

    CertificateManager() {
        this.certificateRequestStorage = CertificateRequestStorage.getInstance();
    }

    public void viewAllPendingRequest() {
         if (certificateRequestStorage.getAllRequests().isEmpty()) {
                    System.out.println("No requests found.");
                    return;
                 }
                    for (CertificateRequest certificateRequest : certificateRequestStorage.getAllRequests()) {
                        if (certificateRequest.getStatus().equals("Pending Approval")) {
                            System.out.println(certificateRequest);
                        }
                    }
    }

    public void approveRequest(Scanner scan) {
                    System.out.print("Enter the Request ID that you want to edit: ");
                    String approveRequest = scan.nextLine();
                    
                for (CertificateRequest certificateRequest : certificateRequestStorage.getAllRequests()) {
                    if (certificateRequestStorage.getAllRequests().isEmpty()) {
                        System.out.println("No requests found.");
                        break;
                     }
                }
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


    public void adminCertificateManagement(Scanner scan) {
        boolean isRunning = true;
        while (isRunning) {
            System.out.println("=== Certificate Management System ===");
            System.out.println("1 - View All Request");
            System.out.println("2 - Approve Request");
            System.out.println("3 - Reject Request");
            System.out.println("4 - Exit");
            int choose = scan.nextInt();
            switch (choose) {
               case 1 -> viewAllPendingRequest();
                case 2 ->  approveRequest(scan);

            }
        }
    }

}