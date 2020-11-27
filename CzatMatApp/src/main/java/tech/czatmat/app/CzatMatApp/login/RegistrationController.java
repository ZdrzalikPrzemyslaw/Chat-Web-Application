package tech.czatmat.app.CzatMatApp.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;


@RestController
@RequestMapping("/registration")

// TODO: 27.11.2020 : https://www.codebyamir.com/blog/user-account-registration-with-spring-boot
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class RegistrationController {

    @Autowired
    private PasswordEncoder passwordEncoder;

    private final UserRepository userRepository;

    public RegistrationController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // TODO: 27.11.2020 Nie jestem pewien implementacji
    // TODO: 27.11.2020 Sprawdzać czy udało się dodać usera
    @RequestMapping(value = "", method = RequestMethod.POST, produces = "application/json")
    public String createUser(@RequestBody Users users, HttpServletResponse response) {
        if (userRepository.existsByLogin(users.getLogin())) {
            response.setStatus(HttpServletResponse.SC_CONFLICT);
            // TODO: 27.11.2020 Make throw exepction?
            return ("User By That Login Already Exists");
        }
        users.setPassword(passwordEncoder.encode(users.getPassword()));
        userRepository.save(users);
        response.setStatus(HttpServletResponse.SC_CREATED);
        return ("User successfully created");
    }

    // TODO: 27.11.2020 Ograniczyć możliwość używania zapytania
    @RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
    public Iterable<Users> getUsers() {
        return userRepository.findAll();
    }

    @RequestMapping(value = "/przyklad", method = RequestMethod.GET, produces = "application/json")
    public String getPrzyklad() {
        return "Siema Registration";
    }
}
