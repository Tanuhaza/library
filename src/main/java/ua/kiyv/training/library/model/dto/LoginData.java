package ua.kiyv.training.library.model.dto;

/**
 * This class represents DTO to transfer login data from controller layer to user instance
 */
public class LoginData {
    protected String email;
    protected String password;

    public String getEmail() {

        return email;
    }

    public String getPassword() {
        return password;
    }

    public LoginData() {
    }

    public LoginData(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
