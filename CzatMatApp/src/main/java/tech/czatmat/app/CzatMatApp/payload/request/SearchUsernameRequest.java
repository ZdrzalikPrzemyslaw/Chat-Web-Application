package tech.czatmat.app.CzatMatApp.payload.request;

import javax.validation.constraints.NotBlank;

public class SearchUsernameRequest {
    @NotBlank
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "LoginRequest{" +
                "username='" + username + '\'' +
                '}';
    }

}
