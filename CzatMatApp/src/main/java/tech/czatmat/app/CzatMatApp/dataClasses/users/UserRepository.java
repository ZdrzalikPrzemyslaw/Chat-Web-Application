package tech.czatmat.app.CzatMatApp.dataClasses.users;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import tech.czatmat.app.CzatMatApp.dataClasses.chat.Chat;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {
    boolean existsByUsername(String username);

    Optional<User> getUsersByUsername(String username);

    boolean existsByEmail(String email);

    Iterable<User> getUsersByNameContainsAndSurnameContains(String name, String surname);

    @Query("select u.* from users u where u.id in (select cu.user_id from chat_users cu where cu.chat_id = :chatId)")
    Iterable<User> getUsersFromChat(@Param("chatId") int chatId);
}
