package tech.czatmat.app.CzatMatApp.payload.request;

import javax.validation.constraints.Size;

public class CreateChatRequest extends ChatUsersRequest {

    @Size(min = 3, max = 30)
    private String chatName;

    public String getChatName() {
        return chatName;
    }

    public void setChatName(String chatName) {
        this.chatName = chatName;
    }

    @Override
    public String toString() {
        return "CreateChatRequest{" +
                "chatName='" + chatName + '\'' +
                "} " + super.toString();
    }
}
