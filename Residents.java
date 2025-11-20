package BarangayManagementSystem;

public class Residents<T extends Users<T>> extends Users<T>{
    private String completeAddress; //in the address we can create an address object here for the user
    private int age;
    private String gender;
    private String fname;
    private String mname;
    private String lname;
    private String contactNumber;
    private String civilStatus;
    private String dateOfBirth;

    Residents(String username, String password, String email, String district, String role, String completeAddress, int age, String gender, String fname, String mname, String lname, String contactNumber, String civilStatus, String dateOfBirth) {
       super(username, password, email, district, role);
       this.completeAddress = completeAddress;
       this.age = age;
       this.gender = gender;
       this.fname = fname;
       this.mname = mname;
       this.lname = lname;
       this.contactNumber = contactNumber;
       this.civilStatus = civilStatus;
       this.dateOfBirth = dateOfBirth;
    }

    //getters
    public String getCompleteAddress() {
        return completeAddress;
    }
    public int getAge() {
        return age;
    }
    public String getGender() {
        return gender;
    }
    public String getFname() {
        return fname;
    }
    public String getMname() {
        return mname;
    }
    public String getLname() {
        return lname;
    }
    public String getContactNumber() {
        return contactNumber;
    }
    public String getCivilStatus() {
        return civilStatus;
    }
    public String getDateOfBirth() {
        return dateOfBirth;
    }


    //setters
    public void setCompleteAddress(String completeAddress) {
        this.completeAddress = completeAddress;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public void setFname(String fname) {
        this.fname = fname;
    }
    public void setLname(String lname) {
        this.lname = lname;
    }
    public void setMname(String mname) {
        this.mname = mname;
    }
    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }
    public void setCivilStatus(String civilStatus) {
        this.civilStatus = civilStatus;
    }
    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

}
