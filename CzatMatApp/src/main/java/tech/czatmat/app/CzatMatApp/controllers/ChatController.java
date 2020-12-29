package tech.czatmat.app.CzatMatApp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import tech.czatmat.app.CzatMatApp.dataClasses.chat.Chat;
import tech.czatmat.app.CzatMatApp.dataClasses.chat.ChatsRepository;
import tech.czatmat.app.CzatMatApp.dataClasses.chat.chat_users.ChatUser;
import tech.czatmat.app.CzatMatApp.dataClasses.chat.chat_users.ChatUsersRepository;
import tech.czatmat.app.CzatMatApp.dataClasses.users.User;
import tech.czatmat.app.CzatMatApp.dataClasses.users.UserRepository;
import tech.czatmat.app.CzatMatApp.payload.request.CreateChatRequest;

import java.sql.Date;


@RestController
@RequestMapping("/chat")
public class ChatController {

    @Autowired
    private final UserRepository userRepository;
    @Autowired
    private final ChatsRepository chatsRepository;
    @Autowired
    private final ChatUsersRepository chatUsersRepository;


    public ChatController(UserRepository userRepository, ChatsRepository chatsRepository, ChatUsersRepository chatUsersRepository) {
        this.userRepository = userRepository;
        this.chatsRepository = chatsRepository;
        this.chatUsersRepository = chatUsersRepository;
    }

    @PreAuthorize("hasRole('SUPER_USER')")
    @RequestMapping(value = "", method = RequestMethod.PUT, produces = "application/json")
    public ResponseEntity<?> createChat(@RequestBody CreateChatRequest createChatRequest) {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userRepository.getUsersByUsername(userDetails.getUsername())
                .orElseThrow(() -> new RuntimeException("Error: User is not found."));
        Chat chat = new Chat(createChatRequest.getChatName(),
                new Date(new java.util.Date().getTime()),
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

        return ResponseEntity.ok("Chat successfully created.");

    }
}
