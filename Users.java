package BarangayManagementSystem;

import java.util.LinkedList;


public abstract class Users<T extends Users<T>> {
    private String username;
    private String password;
    private String email;
    private String district;
    private String role;
    private LinkedList<T> users = new LinkedList<>();   
    Users(String username, String password, String email, String district, String role) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.district = district;
        this.role = role;
    }

    Users() {
    }

    //getters
    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
    public String getEmail() {
        return  email;
    }
    public String getDistrict() {
        return district;
    }
    public String getRole() {
        return role;
    }

    //setters
    public void setUsername(String username) {
        this.username=  username;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setDistrict(String district) {
        this.district = district;
    }
    public void setRole(String role) {
        this.role = role;
    }

    public LinkedList<T> getUsers() {
        return users;
    }
    public void setUsers(LinkedList<T> users) {
        this.users = users;
    }
}
