package tech.czatmat.app.CzatMatApp.dataClasses.chat.chat_users;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("chat_users")
public class ChatUser {
    @Id
    private int id;
    private int chatId;
    private int userId;

    public ChatUser(int id, int chatId, int userId) {
        this.id = id;
        this.chatId = chatId;
        this.userId = userId;
    }

    public ChatUser(int chatId, int userId) {
        this.chatId = chatId;
        this.userId = userId;
    }

    public ChatUser() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getChatId() {
        return chatId;
    }

    public void setChatId(int chatId) {
        this.chatId = chatId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
