package tech.czatmat.app;

import java.util.Date;

public class Message {

    private final String userName;
    private final String message;
    private final Date date;
    private final int chatId;

    private Message(String userName, String message, Date date, int chatId) {
        this.userName = userName;
        this.message = message;
        this.date = date;
        this.chatId = chatId;
    }

    public String getUserName() {
        return userName;
    }

    public String getMessage() {
        return message;
    }

    public Date getDate() {
        return date;
    }

    public int getChatId() {
        return chatId;
    }

    public static Message of(String userName, String message, Date date, int chatId) {
        return new Message(userName, message, date, chatId);
    }
}
