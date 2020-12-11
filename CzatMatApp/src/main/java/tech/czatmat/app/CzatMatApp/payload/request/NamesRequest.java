package tech.czatmat.app.CzatMatApp.payload.request;

import javax.validation.constraints.NotBlank;

public class NamesRequest {
    @NotBlank
    private String username;

    private String newName;
    private String newSurname;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNewName() {
        return newName;
    }

    public void setNewName(String newName) {
        this.newName = newName;
    }

    public String getNewSurname() {
        return newSurname;
    }

    public void setNewSurname(String newSurname) {
        this.newSurname = newSurname;
    }

    @Override
    public String toString() {
        return "NamesRequest{" +
                "username='" + username + '\'' +
                ", name='" + newName + '\'' +
                ", surname='" + newSurname + '\'' +
                '}';
    }
}
