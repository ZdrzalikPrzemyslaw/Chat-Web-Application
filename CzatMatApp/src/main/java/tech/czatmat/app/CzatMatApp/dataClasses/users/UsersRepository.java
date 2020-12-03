package tech.czatmat.app.CzatMatApp.dataClasses.users;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UsersRepository extends CrudRepository<Users, Long> {
    boolean existsByUsername(String username);
    Optional<Users> getUsersByUsername(String username);
    boolean existsByEmail(String email);
}
