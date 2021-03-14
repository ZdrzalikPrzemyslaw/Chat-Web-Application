package tech.czatmat.app.CzatMatApp.dataClasses.authorities;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;


@Table("authorities")
public class Authority {

    @Id
    private Long ID;
    private String username;
    private String role_name;

    public Authority() {
    }

    public Authority(String username, String role_name) {
        this.username = username;
        this.role_name = role_name;
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
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

