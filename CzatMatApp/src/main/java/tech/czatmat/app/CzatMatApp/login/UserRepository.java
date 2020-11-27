package tech.czatmat.app.CzatMatApp.login;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
