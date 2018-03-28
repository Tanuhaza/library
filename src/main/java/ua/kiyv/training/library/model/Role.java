package ua.kiyv.training.library.model;

public enum Role {
    ADMIN("admin"),
    USER("user");

    private String roleName;

    Role(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleName() {
        return roleName;
    }

    public static Role getRole(String roleName) {
        for (Role role : values()) {
            if (role.getRoleName().equals(roleName))
                return role;
        }
        return null;
    }
}
