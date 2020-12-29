package tech.czatmat.app.CzatMatApp.dataClasses.users;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {
    boolean existsByUsername(String username);

    Optional<User> getUsersByUsername(String username);

    boolean existsByEmail(String email);

    Iterable<User> getUsersByNameContainsAndSurnameContains(String name, String surname);
}
