package tech.czatmat.app.CzatMatApp.dataClasses.messages;

import org.springframework.data.repository.CrudRepository;

public interface MessagesRepository extends CrudRepository<Message, Long> {
}
