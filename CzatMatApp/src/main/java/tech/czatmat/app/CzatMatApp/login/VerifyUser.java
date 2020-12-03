package tech.czatmat.app.CzatMatApp.login;

import org.springframework.security.crypto.password.PasswordEncoder;
import tech.czatmat.app.CzatMatApp.dataClasses.users.UsersRepository;
import tech.czatmat.app.CzatMatApp.dataClasses.users.Users;

import java.util.Optional;

public class VerifyUser {

    // TODO: 27.11.2020 https://www.baeldung.com/spring-security-registration-password-encoding-bcrypt
    public static boolean mockVerify(String login, String password) {
        return true;
    }

    public static boolean Verify(String login, String password, UsersRepository usersRepository, PasswordEncoder passwordEncoder) {
        Optional<Users> optionalUser = usersRepository.getUsersByUsername(login);
        if (optionalUser.isPresent()) {
            Users users = optionalUser.get();
            return passwordEncoder.matches(password, users.getPassword());
        }
        return false;
    }

}
