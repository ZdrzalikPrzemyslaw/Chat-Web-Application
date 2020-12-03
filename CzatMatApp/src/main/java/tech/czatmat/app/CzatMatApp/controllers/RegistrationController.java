package tech.czatmat.app.CzatMatApp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import tech.czatmat.app.CzatMatApp.dataClasses.authorities.AuthoritiesRepository;
import tech.czatmat.app.CzatMatApp.dataClasses.authorities.Authorities;
import tech.czatmat.app.CzatMatApp.dataClasses.roles.Roles;
import tech.czatmat.app.CzatMatApp.dataClasses.roles.RolesRepository;
import tech.czatmat.app.CzatMatApp.dataClasses.roles.RoleSource;
import tech.czatmat.app.CzatMatApp.dataClasses.users.Users;
import tech.czatmat.app.CzatMatApp.dataClasses.users.UsersRepository;
import tech.czatmat.app.CzatMatApp.payload.request.RegistrationRequest;
import tech.czatmat.app.CzatMatApp.payload.response.MessageResponse;
import java.util.HashSet;
import java.util.Set;


@RestController
@RequestMapping("/registration")

// TODO: 27.11.2020 : https://www.codebyamir.com/blog/user-account-registration-with-spring-boot
public class RegistrationController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private final UsersRepository usersRepository;

    @Autowired
    private AuthoritiesRepository authoritiesRepository;

    @Autowired
    private RolesRepository rolesRepository;

    public RegistrationController(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    // TODO: 27.11.2020 Nie jestem pewien implementacji
    // TODO: 27.11.2020 Sprawdzać czy udało się dodać usera

    // TODO: 28.11.2020 Obsługiwać brak kolumn i zwracac odpowiedni error
    @RequestMapping(value = "", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<?> createUser(@RequestBody RegistrationRequest request) {
        System.out.println("TUTAJ USER : D");
        if (usersRepository.existsByUsername(request.getUsername())) {
            return ResponseEntity.badRequest().body(new MessageResponse("User By That Login Already Exists"));
        }
        if (usersRepository.existsByEmail(request.getEmail())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Email is already in use!"));
        }
        Users users = new Users(request.getUsername(),
                passwordEncoder.encode(request.getPassword()),
                request.getName(),
                request.getSurname(),
                request.getEmail(),
                Users.ENABLED
        );
        Set<String> strRoles = request.getRole();
        Set<Roles> roles = new HashSet<>();


        if (strRoles == null) {
            Roles userRoles = rolesRepository.findByName(RoleSource.ROLE_USER)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(userRoles);
        } else {
            strRoles.forEach(role -> {
                switch (role) {
                    case RoleSource.ROLE_ADMIN:
                        Roles adminRoles = rolesRepository.findByName(RoleSource.ROLE_ADMIN)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(adminRoles);

                        break;
                    case RoleSource.ROLE_SUPER_USER:
                        Roles supRoles = rolesRepository.findByName(RoleSource.ROLE_SUPER_USER)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(supRoles);

                        break;
                    default:
                        Roles userRoles = rolesRepository.findByName(RoleSource.ROLE_USER)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(userRoles);
                }
            });
        }
        usersRepository.save(users);

        for (var i : roles) {
            Authorities authorities = new Authorities(users.getUsername(), i.getName());
            System.out.println(authorities.getRole_name());
            System.out.println(authorities.getUsername());
            authoritiesRepository.save(authorities);
        }

        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
    }

    // TODO: 27.11.2020 Ograniczyć możliwość używania zapytania
    @RequestMapping(value = "/get_users", method = RequestMethod.GET, produces = "application/json")
    public Iterable<Users> getUsers() {
        return usersRepository.findAll();
    }

    @RequestMapping(value = "/przyklad", method = RequestMethod.GET, produces = "application/json")
    public String getPrzyklad() {
        return "Siema Registration";
    }
}
