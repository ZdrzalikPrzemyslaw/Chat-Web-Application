package tech.czatmat.app.CzatMatApp.login;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<Users, Long> {
    boolean existsByLogin(String login);
    Users getUsersByLogin(String login);
}
