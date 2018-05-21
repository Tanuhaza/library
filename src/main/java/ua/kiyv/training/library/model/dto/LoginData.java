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

    public static class Builder {
        private LoginData instance = new LoginData();

        public Builder email(String email) {
            instance.email = email;
            return this;
        }

        public Builder password(String password) {
            instance.password = password;
            return this;
        }

        public LoginData build() {
            return instance;
        }
    }
}
