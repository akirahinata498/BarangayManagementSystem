package BarangayManagementSystem;

import java.util.ArrayList;
import java.util.List;

public class CertificateRequestStorage {
    private List<CertificateRequest> requests = new ArrayList<>();
    private static CertificateRequestStorage single_instance = null;
    private int nextId;

    public CertificateRequestStorage() {
        nextId = 1;
    }

   
    public CertificateRequest createRequest(String name, String type, String purpose) {
        CertificateRequest request = new CertificateRequest(nextId++, name, type, purpose);
        requests.add(request);
        return request;
    }

    
    public List<CertificateRequest> getAllRequests() {
        return requests;
    }

    public CertificateRequest findRequestById(int id) {
        for (CertificateRequest request : requests) {
            if (request.getId() == id) return request;
        }
        return null; 
    }

    public List<CertificateRequest> findRequestsByName(String name) {
        List<CertificateRequest> result = new ArrayList<>();
        for (CertificateRequest request : requests) {
            if (request.getName().equalsIgnoreCase(name)) result.add(request);
        }
        return result;
    }

    public static synchronized CertificateRequestStorage getInstance() {
        if (single_instance == null) {
            single_instance = new CertificateRequestStorage();
        }
        return single_instance;
    }
}