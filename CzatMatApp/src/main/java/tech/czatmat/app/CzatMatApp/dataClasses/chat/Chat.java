package tech.czatmat.app.CzatMatApp.dataClasses.chat;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.sql.Date;

@Table("chats")
public class Chat {
    @Id
    private int id;
    private String name;
    private Date date;
    private int ownerId;

    public Chat() {
    }

    public Chat(int id, String name, Date date, int ownerId) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.ownerId = ownerId;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

}
