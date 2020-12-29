package tech.czatmat.app.CzatMatApp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import tech.czatmat.app.CzatMatApp.dataClasses.chat.Chat;
import tech.czatmat.app.CzatMatApp.dataClasses.chat.ChatsRepository;
import tech.czatmat.app.CzatMatApp.dataClasses.chat.chat_users.ChatUser;
import tech.czatmat.app.CzatMatApp.dataClasses.chat.chat_users.ChatUsersRepository;
import tech.czatmat.app.CzatMatApp.dataClasses.messages.Message;
import tech.czatmat.app.CzatMatApp.dataClasses.messages.MessagesRepository;
import tech.czatmat.app.CzatMatApp.dataClasses.users.User;
import tech.czatmat.app.CzatMatApp.dataClasses.users.UserRepository;
import tech.czatmat.app.CzatMatApp.payload.request.ChatUsersReqest;
import tech.czatmat.app.CzatMatApp.payload.request.CreateChatRequest;
import tech.czatmat.app.CzatMatApp.payload.response.ChatMessagesResponse;
import tech.czatmat.app.CzatMatApp.payload.response.GetChatsResponse;
import tech.czatmat.app.CzatMatApp.payload.response.MessageResponse;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@PreAuthorize("hasAnyRole('USER', 'SUPER_USER', 'ADMIN')")
@RestController
@RequestMapping("/chat")
public class ChatController {

    @Autowired
    private final UserRepository userRepository;
    @Autowired
    private final ChatsRepository chatsRepository;
    @Autowired
    private final ChatUsersRepository chatUsersRepository;
    @Autowired
    private final MessagesRepository messagesRepository;


    public ChatController(UserRepository userRepository, ChatsRepository chatsRepository, ChatUsersRepository chatUsersRepository, MessagesRepository messagesRepository) {
        this.userRepository = userRepository;
        this.chatsRepository = chatsRepository;
        this.chatUsersRepository = chatUsersRepository;
        this.messagesRepository = messagesRepository;
    }

    @Transactional
    @PreAuthorize("hasRole('SUPER_USER')")
    @RequestMapping(value = "", method = RequestMethod.PUT, produces = "application/json")
    public ResponseEntity<?> createChat(@RequestBody CreateChatRequest createChatRequest) {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userRepository.getUsersByUsername(userDetails.getUsername())
                .orElseThrow(() -> new RuntimeException("Error: User is not found."));
        Chat chat = new Chat(createChatRequest.getChatName(),
                new Timestamp(new java.util.Date().getTime()),
                user.getID());

        chat = chatsRepository.save(chat);

        ChatUser chatOwner = new ChatUser(chat.getId(), user.getID());
        chatUsersRepository.save(chatOwner);


        for (var i : createChatRequest.getUsers()) {
            User userToChat = userRepository.getUsersByUsername(i.getUsername())
                    .orElseThrow(() -> new RuntimeException("Error: User is not found."));
            if (userToChat.getID() != user.getID()) {
                ChatUser chatUser = new ChatUser(chat.getId(), userToChat.getID());
                chatUsersRepository.save(chatUser);
            }
        }

        return ResponseEntity.ok(new MessageResponse("Chat successfully created."));
    }

    @Transactional
    @RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> findChatByName(@RequestParam(value = "chatName", required = false, defaultValue = "") String chatName) {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userRepository.getUsersByUsername(userDetails.getUsername())
                .orElseThrow(() -> new RuntimeException("Error: User is not found."));

        List<GetChatsResponse.ChatResponseData> list = new ArrayList<>();

        for (var i : chatsRepository.getChatByName(chatName, user.getID())) {
            // FIXME: 29.12.2020 created at to last message sent date
            list.add(new GetChatsResponse.ChatResponseData(userRepository.getUsersFromChat(i.getId()), i.getName(), i.getCreatedAt(), i.getId()));
        }

        return ResponseEntity.ok(new GetChatsResponse(list));
    }

    @Transactional
    @RequestMapping(value = "", method = RequestMethod.DELETE, produces = "application/json")
    public ResponseEntity<?> deleteExistingChat(@RequestParam("chatId") int chatId) {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userRepository.getUsersByUsername(userDetails.getUsername())
                .orElseThrow(() -> new RuntimeException("Error: User is not found."));

        if (chatsRepository.existsChatByIdAndOwnerId(chatId, user.getID())) {
            chatsRepository.deleteChatById(chatId);
            return ResponseEntity.ok(new MessageResponse("Chat successfully deleted."));
        }

        return ResponseEntity.status(403).body(new MessageResponse("You don't have access to this chat."));
    }

    @Transactional
    @RequestMapping(value = "", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<?> changeChatName(@RequestParam("chatId") int chatId, @RequestParam("chatName") String chatName) {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userRepository.getUsersByUsername(userDetails.getUsername())
                .orElseThrow(() -> new RuntimeException("Error: User is not found."));

        if (chatsRepository.existsChatByIdAndOwnerId(chatId, user.getID())) {
            Chat chat = chatsRepository.getChatById(chatId)
                    .orElseThrow(() -> new RuntimeException("Error: Chat is not found."));

            Chat newChat = new Chat(chat);
            newChat.setName(chatName);
            chatsRepository.save(newChat);
            return ResponseEntity.ok(new MessageResponse("Chat name changed successfully."));
        }

        return ResponseEntity.status(403).body(new MessageResponse("You don't have access to this chat."));
    }

    @Transactional
    @RequestMapping(value = "/message", method = RequestMethod.PUT, produces = "application/json")
    public ResponseEntity<?> sendMessage(@RequestParam("chatId") int chatId, @RequestBody MessageResponse messageText) {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userRepository.getUsersByUsername(userDetails.getUsername())
                .orElseThrow(() -> new RuntimeException("Error: User is not found."));

        Message message = new Message(chatId, user.getID(), messageText.getMessage(), new Timestamp(new java.util.Date().getTime()));

        messagesRepository.save(message);

        return ResponseEntity.ok(new MessageResponse("Message successfully sent."));
    }

    @Transactional
    @RequestMapping(value = "/message", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> getChatMessages(@RequestParam("chatId") int chatId) {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userRepository.getUsersByUsername(userDetails.getUsername())
                .orElseThrow(() -> new RuntimeException("Error: User is not found."));

        for (var i : userRepository.getUsersFromChat(chatId)) {
            if (i.getID() == user.getID()) {
                var messages = messagesRepository.getMessagesByChatIdOrderByCreatedAtDesc(chatId);
                return ResponseEntity.ok(new ChatMessagesResponse(messages));
            }
        }

        return ResponseEntity.status(403).body(new MessageResponse("You don't have access to this chat."));
    }

    @Transactional
    @RequestMapping(value = "/users", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<?> addUsersToExistingChat(@RequestParam("chatId") int chatId, @RequestBody ChatUsersReqest chatUsersReqest) {

        for (var i : chatUsersReqest.getUsers()) {
            User user = userRepository.getUsersByUsername(i.getUsername())
                    .orElseThrow(() -> new RuntimeException("Error: User is not found."));

            if (!chatUsersRepository.existsChatUserByUserIdAndChatId(user.getID(), chatId)) {
                ChatUser chatUser = new ChatUser(chatId, user.getID());
                chatUsersRepository.save(chatUser);
            }
        }

        return ResponseEntity.ok(new MessageResponse("Users successfully added."));
    }

    @Transactional
    @RequestMapping(value = "/users", method = RequestMethod.DELETE, produces = "application/json")
    public ResponseEntity<?> deleteUsersFromExistingChat(@RequestParam("chatId") int chatId, @RequestBody ChatUsersReqest chatUsersReqest) {

        for (var i : chatUsersReqest.getUsers()) {
            User user = userRepository.getUsersByUsername(i.getUsername())
                    .orElseThrow(() -> new RuntimeException("Error: User is not found."));

            if (chatUsersRepository.existsChatUserByUserIdAndChatId(user.getID(), chatId)) {
                System.out.println(chatId);
                System.out.println(user.getID());
                chatUsersRepository.deleteByChatIdAndUserId(chatId, user.getID());
            }
        }

        return ResponseEntity.ok(new MessageResponse("Users successfully deleted."));
    }

}
