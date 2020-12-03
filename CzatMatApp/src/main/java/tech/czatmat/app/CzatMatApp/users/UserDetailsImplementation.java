package tech.czatmat.app.CzatMatApp.users;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class UserDetailsImplementation implements UserDetails {
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    private int id;
    private String username;
    private String password;
    private String surname;
    private String email;
    private boolean enabled;

    public UserDetailsImplementation(User user){
        this.id = user.getID();
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.email = user.getEmail();
        this.surname = user.getSurname();
        this.enabled = user.isEnabled();
    }

    public UserDetailsImplementation(int id, String username, String password, String surname, String email, boolean enabled) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.surname = surname;
        this.email = email;
        this.enabled = enabled;
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
