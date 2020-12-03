package tech.czatmat.app.CzatMatApp.dataClasses.authorities;

import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "authorities")
public class Authorities {
    @Id
    private int ID;
    private String username;
    private String role_name;

    public Authorities() {
    }

    public Authorities(String username, String role_name) {
        this.username = username;
        this.role_name = role_name;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }
}

