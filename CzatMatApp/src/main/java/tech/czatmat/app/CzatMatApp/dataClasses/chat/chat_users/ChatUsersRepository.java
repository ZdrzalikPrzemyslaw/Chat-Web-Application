package tech.czatmat.app.CzatMatApp.dataClasses.chat.chat_users;

import org.springframework.data.repository.CrudRepository;

public interface ChatUsersRepository extends CrudRepository<ChatUser, Long> {

    boolean existsChatUserByUserIdAndChatId(int userId, int chatId);

}
