package BarangayManagementSystem;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.LinkedList;


public abstract class Users<T extends Users<T>> {
    private String username;
    private String password;
    private String email;
    private String district;
    private String role;
    private LinkedList<T> users = new LinkedList<>();   
    Users(String username, String password, String email, String district, String role) {
        setUsername(username);
        setPassword(password);
        setEmail(email);
        setDistrict(district);
        setRole(role);
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
        this.password = hashPassword(password);
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
        private String hashPassword(String password) { 
        		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			byte[] encodedhash = digest.digest(password.getBytes());
			StringBuilder hexstring = new StringBuilder();
			for (byte b : encodedhash) {
				String hex = Integer.toHexString(0xff & b);
				if (hex.length() == 1 ) hexstring.append('0');
				hexstring.append(hex);
			}
			return hexstring.toString();
		}catch (NoSuchAlgorithmException e) {
			throw new RuntimeException("Error: SHA-256 Algorithm not found", e);
		}
    }

}
