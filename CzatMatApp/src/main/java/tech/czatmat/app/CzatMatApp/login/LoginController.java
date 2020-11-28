package tech.czatmat.app.CzatMatApp.login;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/login")
@CrossOrigin(origins = "*", allowedHeaders = "*")
// TODO: 27.11.2020 fix class
public class LoginController {
    // TODO: 27.11.2020 https://bezkoder.com/spring-boot-jwt-authentication/
//    @Autowired
//    private PasswordEncoder passwordEncoder;

    private final UserRepository userRepository;

    public LoginController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // TODO: 27.11.2020 Return token
    @RequestMapping(value = "", method = RequestMethod.POST, produces = "application/json")
    public void loginUser(@RequestBody Users users, HttpServletResponse response) {
        if (!userRepository.existsByLogin(users.getLogin())) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }
        response.setStatus(HttpServletResponse.SC_ACCEPTED);
//        if(VerifyUser.Verify(users.getLogin(), users.getPassword(), userRepository, passwordEncoder)){
//            response.setStatus(HttpServletResponse.SC_ACCEPTED);
//        } else {
//            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//        }
    }


    @RequestMapping(value = "/przyklad", method = RequestMethod.GET, produces = "application/json")
    public String getPrzyklad() {
        return "Siema Login";
    }

}
