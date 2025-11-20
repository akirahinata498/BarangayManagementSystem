package BarangayManagementSystem;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public abstract class Authentication<T extends Users<T>> extends Users<T> {
    

    public Authentication(){ 

    }
    public void login(Scanner scan) {
        
    }
    public String hashPassword(String password) { 
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


    public boolean validatePassword(String passsword) {
        return false;
    }
    public boolean validateEmail(String email) {
        return false;
    }
}
