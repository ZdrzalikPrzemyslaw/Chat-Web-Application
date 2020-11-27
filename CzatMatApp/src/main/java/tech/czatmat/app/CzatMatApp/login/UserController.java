package tech.czatmat.app.CzatMatApp.login;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public User createUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    @GetMapping("/")
    public Iterable<User> getUsers() {
        return userRepository.findAll();
    }

}
