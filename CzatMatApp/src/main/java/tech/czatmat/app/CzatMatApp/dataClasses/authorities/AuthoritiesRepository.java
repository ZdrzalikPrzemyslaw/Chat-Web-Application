package tech.czatmat.app.CzatMatApp.dataClasses.authorities;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AuthoritiesRepository extends CrudRepository<Authorities, Long> {
    List<Authorities> getAllByUsername(String user);
}
