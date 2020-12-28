package tech.czatmat.app.CzatMatApp.dataClasses.messages;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.sql.Date;

@Table("chat_messages")
public class Message {
    @Id
    private int ID;
    private int chatId;
    private int userId;
    private int fileId;
    private String text;
    private Date createdAt;
    private int baseKeyId;

    public Message(int ID, int chatId, int userId, int fileId, String text, Date createdAt, int baseKeyId) {
        this.ID = ID;
        this.chatId = chatId;
        this.userId = userId;
        this.fileId = fileId;
        this.text = text;
        this.createdAt = createdAt;
        this.baseKeyId = baseKeyId;
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

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
