package tech.czatmat.app.CzatMatApp.payload.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UsernameRequest {
    @NotBlank
    private String username;

    @NotBlank
    @Size(min = 3, max = 20)
    private String newUsername;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNewUsername() {
        return newUsername;
    }

    public void setNewUsername(String newUsername) {
        this.newUsername = newUsername;
    }
}
