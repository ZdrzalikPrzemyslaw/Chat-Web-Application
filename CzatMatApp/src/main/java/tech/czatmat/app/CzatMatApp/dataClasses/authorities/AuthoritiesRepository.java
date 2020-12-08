package tech.czatmat.app.CzatMatApp.dataClasses.authorities;

import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface AuthoritiesRepository extends CrudRepository<Authority, Long> {
    List<Authority> getAllByUsername(String user);
}
