package tech.czatmat.app.CzatMatApp.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import tech.czatmat.app.CzatMatApp.users.authorities.AuthoritiesRepository;

@Service
public class UserDetailsServiceImplementation implements UserDetailsService{
    @Autowired
    UserRepository userRepository;

    @Autowired
    AuthoritiesRepository authoritiesRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.getUsersByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User not found with name " + username));
        var authorities = authoritiesRepository.getAllByUsername(username);
        return UserDetailsImplementation.build(user, authorities);
    }
}
