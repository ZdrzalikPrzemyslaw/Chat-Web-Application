package tech.czatmat.app.CzatMatApp.login;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<Users, Long> {
    public boolean existsByLogin(String name);
}
