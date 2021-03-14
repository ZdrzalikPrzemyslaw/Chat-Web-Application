package tech.czatmat.app.CzatMatApp.dataClasses.chat.chat_users;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface ChatUsersRepository extends CrudRepository<ChatUser, Long> {

    boolean existsByUserIdAndChatId(int userId, int chatId);

    @Query("delete from chat_users where chat_id = :chatId and user_id = :userId")
    @Modifying
    @Transactional
    void deleteByChatIdAndUserId(@Param("chatId") int chatId, @Param("userId") int userId);
}
