package tech.czatmat.app.CzatMatApp.payload.response;

import tech.czatmat.app.CzatMatApp.dataClasses.users.User;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;

public class GetChatsResponse {

    private final List<ChatResponseData> chatsList;


    public GetChatsResponse(Iterable<ChatResponseData> chatResponseDataIterable) {
        chatsList = new LinkedList<>();
        for (var i : chatResponseDataIterable) {
            chatsList.add(i);
        }
    }

    public List<ChatResponseData> getChatsList() {
        return chatsList;
    }

    public static class ChatResponseData {
        private final List<UserDataResponse> userList;
        private final String chatName;
        // TODO: 29.12.2020 ZROBIC TO
        private final Timestamp lastMessageDate;

        public ChatResponseData(List<UserDataResponse> userList, String chatName, Timestamp lastMessageDate) {
            this.userList = userList;
            this.chatName = chatName;
            this.lastMessageDate = lastMessageDate;
        }

        public ChatResponseData(Iterable<User> userList, String chatName, Timestamp lastMessageDate) {
            this.userList = new LinkedList<>();
            for (var i : userList) {
                this.userList.add(new UserDataResponse(i));
            }
            this.chatName = chatName;
            this.lastMessageDate = lastMessageDate;
        }

        public List<UserDataResponse> getUserList() {
            return userList;
        }

        public String getChatName() {
            return chatName;
        }

        public Timestamp getLastMessageDate() {
            return lastMessageDate;
        }
    }

}
