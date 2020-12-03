package tech.czatmat.app.CzatMatApp.dataClasses.users;

import io.micrometer.core.lang.Nullable;
import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity(name = "users")
public class Users {

    @Id
    private int ID;
    private String username;
    // Password as a hash, not plain text
    private String password;
    private String name;
    private String surname;
    private String email;
    private Integer enabled;
    public static final int ENABLED = 1;
    public static final int DISABLED = 0;

    public Users() {
    }

    @Override
    public String toString() {
        return "Users{" +
                "ID=" + ID +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", enabled=" + enabled +
                '}';
    }

    public Users(String username, String password, String name, String surname, @Nullable String email, Integer enabled) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.enabled = enabled;
    }

    public boolean isEnabled() {
        return enabled == 1;
    }

    public void setEnabled(Integer enabled) {
        this.enabled = enabled;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
