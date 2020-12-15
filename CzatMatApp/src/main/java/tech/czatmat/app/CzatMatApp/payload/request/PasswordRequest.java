package tech.czatmat.app.CzatMatApp.payload.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class PasswordRequest {
    private String username;

    @NotBlank
    @Size(min = 6, max = 40)
    private String newPassword;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
}
