package BarangayManagementSystem;

public class Admin<T extends Users<T>> extends Users<T>{
    private String accessLevel;
    Admin(String username, String password, String email, String district, String accessLevel, String role) {
        super(username, password, email, district, role);
        this.accessLevel = accessLevel;
    }
    
    public String getAccessLevel() {
        return accessLevel;
    }

    public void setAccessLevel(String accessLevel) {
        this.accessLevel = accessLevel;
    }

}
