package com.example.Spring_Security_Bus.security;

import com.example.Spring_Security_Bus.entity.Users;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
@Data
@AllArgsConstructor
public class CustomUserDetail implements UserDetails {
    Users users;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = null;
        try {
            authorities = users.getUserRoles().stream().map(e ->{
                String role = e.getRole().getName();
                return new SimpleGrantedAuthority(role);
            }).collect(Collectors.toList());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return authorities;
    }

    @Override
    public String getPassword() {
        return users.getPassword();
    }

    @Override
    public String getUsername() {
        return users.getUsername();
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
