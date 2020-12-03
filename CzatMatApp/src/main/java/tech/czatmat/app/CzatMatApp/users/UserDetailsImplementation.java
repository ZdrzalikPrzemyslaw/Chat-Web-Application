package tech.czatmat.app.CzatMatApp.users;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import tech.czatmat.app.CzatMatApp.users.authorities.Authority;

import java.util.Collection;
import java.util.Collections;

public class UserDetailsImplementation implements UserDetails {
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    private Collection<? extends GrantedAuthority> authorities;
    private int id;
    private String username;
    private String password;
    private String surname;
    private String email;
    private boolean enabled;

    public UserDetailsImplementation(int id, String username, String password, String surname, String email,
                                     boolean enabled, Collection<? extends GrantedAuthority> authorities) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.surname = surname;
        this.email = email;
        this.enabled = enabled;
        this.authorities = authorities;
    }

    public static UserDetailsImplementation build(User user, Authority authority){
        return new UserDetailsImplementation(user.getID(), user.getUsername(), user.getPassword(), user.getSurname(), user.getEmail(), authority);
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
