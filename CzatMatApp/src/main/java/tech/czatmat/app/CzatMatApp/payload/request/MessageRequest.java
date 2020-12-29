package tech.czatmat.app.CzatMatApp.payload.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.sql.Timestamp;

public class MessageRequest {

    @NotBlank
    private int chat_id;

    @NotBlank
    private int user_id;

    @Size(max = 2048)
    private String text;

    @NotBlank
    private Timestamp created_at;

    @Override
    public String toString() {
        return "MessageRequest{" +
                "chat_id=" + chat_id +
                ", user_id=" + user_id +
                ", text='" + text + '\'' +
                ", created_at=" + created_at +
                '}';
    }

    public int getChat_id() {
        return chat_id;
    }

    public void setChat_id(int chat_id) {
        this.chat_id = chat_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

}
