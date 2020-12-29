package tech.czatmat.app.CzatMatApp.payload.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

public class EditUserRequest {

    @Size(max = 100)
    @Email
    private String email;

    @Size(max = 50)
    private String name;

    @Size(max = 50)
    private String surname;

    @Size(min = 6, max = 40)
    private String oldPassword;


    @Size(min = 6, max = 40)
    private String newPassword;

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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    @Override
    public String toString() {
        return "editUserRequest{" +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", oldPassword='" + oldPassword + '\'' +
                ", newPassword='" + newPassword + '\'' +
                '}';
    }
}
