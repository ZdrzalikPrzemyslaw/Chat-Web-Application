package tech.czatmat.app.CzatMatApp.users.authorities;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AuthoritiesRepository extends CrudRepository<Authority, Long> {
    List<Authority> getAllByUsername(String user);
}
