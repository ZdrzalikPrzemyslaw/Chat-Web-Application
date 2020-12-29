package tech.czatmat.app.CzatMatApp.payload.request;

import javax.validation.constraints.NotBlank;
import java.util.List;

public class ChatUsersReqest {

    @NotBlank
    private List<CreateChatRequest.ChatSubRequest> users;

    public List<CreateChatRequest.ChatSubRequest> getUsers() {
        return users;
    }

    public void setUsers(List<CreateChatRequest.ChatSubRequest> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "ChatUsersReqest{" +
                "users=" + users +
                '}';
    }

    public static class ChatSubRequest {
        private String username;

        public String getUsername() {
            return username;
        }
    }
}
