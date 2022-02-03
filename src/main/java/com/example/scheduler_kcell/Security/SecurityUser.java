package com.example.scheduler_kcell.Security;

import com.example.scheduler_kcell.Model.Status;
import com.example.scheduler_kcell.Model.model_roles;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Data
public class SecurityUser implements UserDetails {

    private final String username;
    private final String password;
    private final List<SimpleGrantedAuthority> authorities;
    private final boolean isActive;

    public SecurityUser(String name, String password, List<SimpleGrantedAuthority> authorities, boolean isActive) {
        this.username = name;
        this.password = password;
        this.authorities = authorities;
        this.isActive = isActive;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return isActive;
    }

    @Override
    public boolean isAccountNonLocked() {
        return isActive;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return isActive;
    }

    @Override
    public boolean isEnabled() {
        return isActive;
    }


    public static UserDetails from_Model_roles(model_roles model_roles) {
        return new User(
                model_roles.getEmail(),
                model_roles.getPassword(),
                model_roles.getStatus().equals(Status.ACTIVE),
                model_roles.getStatus().equals(Status.ACTIVE),
                model_roles.getStatus().equals(Status.ACTIVE),
                model_roles.getStatus().equals(Status.ACTIVE),
                model_roles.getRole().getAuthorities()
        );
    }
}