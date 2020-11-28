package tech.czatmat.app.CzatMatApp.users;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<Users, Long> {
    boolean existsByUsername(String username);
    Users getUsersByUsername(String username);
}
