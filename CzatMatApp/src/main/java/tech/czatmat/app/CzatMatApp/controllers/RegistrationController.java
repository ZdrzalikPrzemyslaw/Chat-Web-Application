package tech.czatmat.app.CzatMatApp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import tech.czatmat.app.CzatMatApp.dataClasses.authorities.AuthoritiesRepository;
import tech.czatmat.app.CzatMatApp.dataClasses.authorities.Authority;
import tech.czatmat.app.CzatMatApp.dataClasses.roles.Role;
import tech.czatmat.app.CzatMatApp.dataClasses.roles.RoleRepository;
import tech.czatmat.app.CzatMatApp.dataClasses.roles.RoleSource;
import tech.czatmat.app.CzatMatApp.dataClasses.users.User;
import tech.czatmat.app.CzatMatApp.dataClasses.users.UserRepository;
import tech.czatmat.app.CzatMatApp.payload.request.RegistrationRequest;
import tech.czatmat.app.CzatMatApp.payload.response.MessageResponse;

import java.util.HashSet;
import java.util.Set;


@RestController
@RequestMapping("/registration")
public class RegistrationController {

    @Autowired
    private final UserRepository userRepository;
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AuthoritiesRepository authoritiesRepository;

    @Autowired
    private RoleRepository roleRepository;

    public RegistrationController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    @RequestMapping(value = "", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<?> createUser(@RequestBody RegistrationRequest request) {
        if (userRepository.existsByUsername(request.getUsername())) {
            return ResponseEntity.badRequest().body(new MessageResponse("User By That Login Already Exists"));
        }
        if (userRepository.existsByEmail(request.getEmail())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Email is already in use!"));
        }

        User user = new User(request.getUsername(),
                passwordEncoder.encode(request.getPassword()),
                request.getName(),
                request.getSurname(),
                request.getEmail(),
                User.ENABLED
        );
        Set<Role> roles = new HashSet<>();


        Role userRole = roleRepository.findByName(RoleSource.ROLE_USER)
                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
        roles.add(userRole);

        userRepository.save(user);

        for (var i : roles) {
            authoritiesRepository.save(new Authority(user.getUsername(), i.getName()));
        }

        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
    }

}
