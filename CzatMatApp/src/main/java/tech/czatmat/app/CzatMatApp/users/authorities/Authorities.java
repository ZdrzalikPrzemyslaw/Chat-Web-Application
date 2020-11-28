package tech.czatmat.app.CzatMatApp.users.authorities;

public class Authorities {

    private String login;
    private String authority;

    public Authorities() {
    }

    public Authorities(String login, String authority) {
        this.login = login;
        this.authority = authority;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }
}

