package tech.czatmat.app.CzatMatApp.dataClasses.messages;

import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface MessagesRepository extends CrudRepository<Message, Long> {
    List<Message> getMessagesByChatIdOrderByCreatedAtDesc(int id);

    Optional<Message> getMessageByID(int id);

    boolean existsMessageByIDAndUserId(int messageId, int userId);

}
