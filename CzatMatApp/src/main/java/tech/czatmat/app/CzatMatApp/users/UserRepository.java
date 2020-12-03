package tech.czatmat.app.CzatMatApp.users;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    boolean existsByUsername(String username);
    User getUsersByUsername(String username);
}
