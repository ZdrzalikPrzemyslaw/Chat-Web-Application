package tech.czatmat.app.CzatMatApp.login;

import org.springframework.security.crypto.password.PasswordEncoder;
import tech.czatmat.app.CzatMatApp.users.UserRepository;
import tech.czatmat.app.CzatMatApp.users.Users;

public class VerifyUser {

    // TODO: 27.11.2020 https://www.baeldung.com/spring-security-registration-password-encoding-bcrypt
    public static boolean mockVerify(String login, String password) {
        return true;
    }

    public static boolean Verify(String login, String password, UserRepository userRepository, PasswordEncoder passwordEncoder) {
        Users user = userRepository.getUsersByLogin(login);
        return passwordEncoder.matches(password, user.getPassword());
    }

}
