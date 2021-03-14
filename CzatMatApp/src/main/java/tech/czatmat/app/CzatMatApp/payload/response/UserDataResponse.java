package tech.czatmat.app.CzatMatApp.payload.response;

import tech.czatmat.app.CzatMatApp.dataClasses.users.User;

public class UserDataResponse {

    private String name;
    private String surname;
    private String email;
    private String username;
    private int id;

    private UserDataResponse() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public UserDataResponse(User user) {
        this.name = user.getName();
        this.surname = user.getSurname();
        this.email = user.getEmail();
        this.username = user.getUsername();
        this.id = user.getID();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
