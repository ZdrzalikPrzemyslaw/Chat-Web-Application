package tech.czatmat.app.CzatMatApp.payload.request;

import javax.validation.constraints.NotBlank;

public class SearchNameSurnameRequest {
    @NotBlank
    private String name;

    @NotBlank
    private String surname;

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "LoginRequest{" +
                "username='" + name + '\'' +
                '}';
    }

}
