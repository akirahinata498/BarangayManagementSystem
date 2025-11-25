package BarangayManagementSystem;

public interface MenuValidation<T extends Users> extends Menu {
    void CheckUserAuth(T users);
    boolean CheckUserAuth(String username, String password);
    void setUserInfo(T users);
    T getUserInfo();
    boolean isUserValidated();
    void setUserValidation(boolean userValidation);
}