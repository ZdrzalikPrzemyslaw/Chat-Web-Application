package tech.czatmat.app.CzatMatApp.dataClasses.chat;

import org.springframework.data.repository.CrudRepository;

public interface ChatsRepository extends CrudRepository<Long, Chat> {
}
