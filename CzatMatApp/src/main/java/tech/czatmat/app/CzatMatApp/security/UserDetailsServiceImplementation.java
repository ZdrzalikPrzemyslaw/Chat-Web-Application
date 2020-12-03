package tech.czatmat.app.CzatMatApp.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import tech.czatmat.app.CzatMatApp.dataClasses.authorities.AuthoritiesRepository;
import tech.czatmat.app.CzatMatApp.dataClasses.users.Users;
import tech.czatmat.app.CzatMatApp.dataClasses.users.UsersRepository;

@Service
public class UserDetailsServiceImplementation implements UserDetailsService {
    @Autowired
    UsersRepository usersRepository;

    @Autowired
    AuthoritiesRepository authoritiesRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users users = usersRepository.getUsersByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User not found with name " + username));
        var authorities = authoritiesRepository.getAllByUsername(username);
        return UserDetailsImplementation.build(users, authorities);
    }
}
