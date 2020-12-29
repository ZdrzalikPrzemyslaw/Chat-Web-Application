package tech.czatmat.app.CzatMatApp.payload.response;

import tech.czatmat.app.CzatMatApp.dataClasses.users.User;

public class SearchSingleUserResponse {

    private String name;
    private String surname;
    private String email;

    private SearchSingleUserResponse() {
    }

    public SearchSingleUserResponse(User user) {
        this.name = user.getName();
        this.surname = user.getSurname();
        this.email = user.getEmail();
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
