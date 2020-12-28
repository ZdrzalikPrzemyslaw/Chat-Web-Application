package tech.czatmat.app.CzatMatApp.dataClasses.users;

import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {
    boolean existsByUsername(String username);

    Optional<User> getUsersByUsername(String username);

    List<User> getUsersByUsernameContainsAndSurnameContains(String username, String surname);

    boolean existsByEmail(String email);
}
