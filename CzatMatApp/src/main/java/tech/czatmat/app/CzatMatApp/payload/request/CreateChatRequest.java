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

    public static class ChatSubRequest {
        private String username;

        public String getUsername() {
            return username;
        }
    }

    @Override
    public String toString() {
        return "CreateChatRequest{" +
                "users=" + users +
                ", chatName='" + chatName + '\'' +
                '}';
    }
}
