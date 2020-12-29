package tech.czatmat.app.CzatMatApp.payload.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

public class CreateChatRequest {

    @NotBlank
    private List<ChatSubRequest> users;

    @Size(min = 3, max = 30)
    private String chatName;

    public String getChatName() {
        return chatName;
    }

    public void setChatName(String chatName) {
        this.chatName = chatName;
    }

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
