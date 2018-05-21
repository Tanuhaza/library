package ua.kiyv.training.library.model.dto;

/**
 * This class represents DTO to transfer register data to user instance
 */
public class RegisterData extends LoginData {
    private String firstName;
    private String lastName;
    private String phone;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private RegisterData instance = new RegisterData();

        private Builder() {
        }

        public Builder firstName(String firstName) {
            instance.firstName = firstName;
            return this;
        }

        public Builder lastName(String lastName) {
            instance.lastName = lastName;
            return this;
        }

        public Builder phone(String phone) {
            instance.phone = phone;
            return this;
        }

        public Builder email(String email) {
            instance.email = email;
            return this;
        }

        public Builder password(String password) {
            instance.password = password;
            return this;
        }

        public RegisterData build() {
            return instance;
        }
    }
}
