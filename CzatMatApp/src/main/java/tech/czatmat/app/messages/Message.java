package tech.czatmat.app.messages;

import java.util.Date;

public class Message {

    private final String userName;
    private final String message;
    private final Date date;
    private final int chatId;
    private final int messageId;

    private Message(String userName, String message, Date date, int chatId, int messageId) {
        this.userName = userName;
        this.message = message;
        this.date = date;
        this.chatId = chatId;
        this.messageId = messageId;
    }

    public int getMessageId() {
        return messageId;
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

    public static Message of(String userName, String message, Date date, int chatId, int messageId) {
        return new Message(userName, message, date, chatId, messageId);
    }
}
