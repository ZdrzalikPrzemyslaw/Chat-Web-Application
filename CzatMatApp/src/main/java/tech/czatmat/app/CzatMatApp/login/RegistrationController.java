package tech.czatmat.app.CzatMatApp.login;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/registration")

// TODO: 27.11.2020 : https://www.codebyamir.com/blog/user-account-registration-with-spring-boot
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class RegistrationController {
    private final UserRepository userRepository;

    public RegistrationController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @RequestMapping(value = "", method = RequestMethod.POST, produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Users createUser(@RequestBody Users users) {
        return userRepository.save(users);
    }

    @RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
    public Iterable<Users> getUsers() {
        return userRepository.findAll();
    }

    @RequestMapping(value = "/przyklad", method = RequestMethod.GET, produces = "application/json")
    public String getPrzyklad() {
        return "Siema Registration";
    }
}
