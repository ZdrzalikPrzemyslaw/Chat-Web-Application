package tech.czatmat.app.CzatMatApp.login;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/login")
@CrossOrigin(origins = "*", allowedHeaders = "*")
// TODO: 27.11.2020 fix class
public class LoginController {

    private final UserRepository userRepository;

    public LoginController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("")
    public void loginUser(@RequestBody Users users, HttpServletResponse response) {
        if (!userRepository.existsByLogin(users.getLogin())) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }
        if (VerifyUser.mockVerify(users.getLogin(), users.getPassword())) {
            response.setStatus(HttpServletResponse.SC_ACCEPTED);
        } else {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        }
    }


    @RequestMapping(value = "/przyklad", method = RequestMethod.GET, produces = "application/json")
    public String getPrzyklad() {
        return "Siema Login";
    }

}
