package tech.czatmat.app.CzatMatApp.dataClasses.chat;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.sql.Timestamp;

@Table("chats")
public class Chat {
    @Id
    private int id;
    private String name;
    private Timestamp createdAt;
    private int ownerId;

    public Chat() {
    }

    public Chat(Chat chat){
        this.id = chat.id;
        this.name = chat.name;
        this.createdAt = chat.createdAt;
        this.ownerId = chat.ownerId;
    }

    public Chat(int id, String name, Timestamp createdAt, int ownerId) {
        this.id = id;
        this.name = name;
        this.createdAt = createdAt;
        this.ownerId = ownerId;
    }

    public Chat(String name, Timestamp createdAt, int ownerId) {
        this.name = name;
        this.createdAt = createdAt;
        this.ownerId = ownerId;
    }

    @Override
    public String toString() {
        return "Chat{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", createdAt=" + createdAt +
                ", ownerId=" + ownerId +
                '}';
    }

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

}
