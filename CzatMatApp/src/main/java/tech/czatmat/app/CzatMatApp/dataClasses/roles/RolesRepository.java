package tech.czatmat.app.CzatMatApp.dataClasses.roles;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface RolesRepository extends CrudRepository<Roles, Long> {
    Optional<Roles> findByName(String name);
}