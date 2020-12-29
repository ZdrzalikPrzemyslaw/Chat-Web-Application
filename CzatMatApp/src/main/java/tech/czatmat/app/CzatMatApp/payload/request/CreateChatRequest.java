package tech.czatmat.app.CzatMatApp.payload.request;

import javax.validation.constraints.NotBlank;
import java.util.List;

public class CreateChatRequest {

    @NotBlank
    private List<ChatSubRequest> list;

    public List<ChatSubRequest> getList() {
        return list;
    }

    public void setList(List<ChatSubRequest> list) {
        this.list = list;
    }

    private static class ChatSubRequest {
        private String username;
    }

    @Override
    public String toString() {
        return "CreateChatRequest{" +
                "list=" + list +
                '}';
    }
}
