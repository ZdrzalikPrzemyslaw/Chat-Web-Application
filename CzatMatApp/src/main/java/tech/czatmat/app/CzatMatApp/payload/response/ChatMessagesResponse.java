package tech.czatmat.app.CzatMatApp.payload.response;

import com.sun.istack.Nullable;
import tech.czatmat.app.CzatMatApp.dataClasses.messages.Message;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class ChatMessagesResponse {

    private final List<ChatMessage> messages;

    public ChatMessagesResponse(List<Message> messages) {
        this.messages = new ArrayList<>();
        for (var i : messages) {
            this.messages.add(new ChatMessage(i.getText(), i.getCreatedAt(), i.getUserId(), i.getBaseKeyId(), i.getChatId()));
        }
    }

    public List<ChatMessage> getMessages() {
        return messages;
    }

    public static class ChatMessage {
        private final String text;
        private final Timestamp createdAt;
        private final int senderId;
        @Nullable
        private final int base_key_id;
        private final int chatId;

        public ChatMessage(String text, Timestamp createdAt, int senderId, int base_key_id, int chatId) {
            this.text = text;
            this.createdAt = createdAt;
            this.senderId = senderId;
            this.base_key_id = base_key_id;
            this.chatId = chatId;
        }

        public String getText() {
            return text;
        }

        public Timestamp getCreatedAt() {
            return createdAt;
        }

        public int getSenderId() {
            return senderId;
        }

        public int getBase_key_id() {
            return base_key_id;
        }

        public int getChatId() {
            return chatId;
        }
    }

}
