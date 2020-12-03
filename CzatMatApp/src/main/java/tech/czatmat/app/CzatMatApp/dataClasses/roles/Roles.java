package tech.czatmat.app.CzatMatApp.dataClasses.roles;

import org.springframework.data.annotation.Id;
import javax.persistence.Table;

@Table(name = "roles")
public class Roles {

    @Id
    private Integer id;
    private String name;

    public Roles() {
    }

    public Roles(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}