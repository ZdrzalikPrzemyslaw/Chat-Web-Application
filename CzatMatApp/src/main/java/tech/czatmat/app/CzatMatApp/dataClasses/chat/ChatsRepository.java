package tech.czatmat.app.CzatMatApp.dataClasses.chat;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface ChatsRepository extends CrudRepository<Chat, Long> {

    @Query("select c.* from chats c where c.ID in (select cu.chat_id from chat_users cu where cu.user_id = :userId) and c.name like '%' + :name + '%'")
    Iterable<Chat> getChatByName(@Param("name") String name, @Param("userId") int userId);

    boolean existsChatById(int chatId);

    Optional<Chat> getChatById(int chatId);

    @Query("delete from chats where id = :chatId")
    @Modifying
    @Transactional
    void deleteChatById(@Param("chatId") int chatId);

    boolean existsChatByIdAndOwnerId(int chatId, int ownerId);

}
