package tech.czatmat.app.CzatMatApp.dataClasses.messages;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MessagesRepository extends CrudRepository<Message, Long> {
    List<Message> getMessagesByChatIdOrderByCreatedAtDesc(int id);
}
