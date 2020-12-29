package tech.czatmat.app.CzatMatApp.dataClasses.messages;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.sql.Timestamp;

@Table("chat_messages")
public class Message {
    private final static int NOT_ENCRYPTED_MESSAGE_ID = -1;
    @Id
    private int ID;
    private int chatId;
    private int userId;
    private Integer fileId;
    private String text;
    private Timestamp createdAt;
    private int baseKeyId;

    public Message(int ID, int chatId, int userId, int fileId, String text, Timestamp createdAt, int baseKeyId) {
        this.ID = ID;
        this.chatId = chatId;
        this.userId = userId;
        this.fileId = fileId;
        this.text = text;
        this.createdAt = createdAt;
        this.baseKeyId = baseKeyId;
    }

    public Message(int chatId, int userId, String text, Timestamp createdAt) {
        this.chatId = chatId;
        this.userId = userId;
        this.fileId = null;
        this.text = text;
        this.createdAt = createdAt;
        this.baseKeyId = NOT_ENCRYPTED_MESSAGE_ID;
    }

    public Message() {
    }

    public int getBaseKeyId() {
        return baseKeyId;
    }

    public void setBaseKeyId(int baseKeyId) {
        this.baseKeyId = baseKeyId;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
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

    public int getFileId() {
        return fileId;
    }

    public void setFileId(int fileId) {
        this.fileId = fileId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }
}
