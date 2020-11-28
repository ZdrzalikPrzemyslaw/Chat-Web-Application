package tech.czatmat.app.CzatMatApp.users;

import io.micrometer.core.lang.Nullable;
import org.springframework.data.annotation.Id;

public class Users {

    @Id
    private int ID;
    private String login;
    // Password as a hash, not plain text
    private String password;
    private String name;
    private String surname;
    private String email;

    public Users() {
    }

    public Users(String login, String password, String name, String surname, @Nullable String email) {
        this.login = login;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.email = email;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
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
