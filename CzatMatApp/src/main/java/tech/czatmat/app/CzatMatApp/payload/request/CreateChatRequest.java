package tech.czatmat.app.CzatMatApp.payload.request;

import javax.validation.constraints.NotBlank;
import java.util.List;

public class CreateChatRequest {

    @NotBlank
    private List<ChatSubRequest> users;

    public List<ChatSubRequest> getUsers() {
        return users;
    }

    public void setUsers(List<ChatSubRequest> users) {
        this.users = users;
    }

    private static class ChatSubRequest {
        private String username;
    }

    @Override
    public String toString() {
        return "CreateChatRequest{" +
                "list=" + users +
                '}';
    }
}
