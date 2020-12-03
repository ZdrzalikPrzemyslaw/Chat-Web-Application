package tech.czatmat.app.CzatMatApp.dataClasses.roles;

public class RoleSource {

    private RoleSource() {
    }

    public static String getRoleUser() {
        return "ROLE_USER";
    }

    public static String getRoleSuperUser() {
        return "ROLE_SUPER_USER";
    }

    public static String getRoleAdmin() {
        return "ROLE_ADMIN";
    }

}
