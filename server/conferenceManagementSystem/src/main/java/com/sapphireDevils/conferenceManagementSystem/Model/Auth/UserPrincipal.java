package com.sapphireDevils.conferenceManagementSystem.Model.Auth;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Set;

@Data
public class UserPrincipal implements UserDetails {

    private static final long serialVersionUID = 1L;
    private User user;

    public UserPrincipal(User user, Set<? extends GrantedAuthority> authorities) {
        this.user = user;
        this.authorities = authorities;
        System.out.println(authorities);
        authorities.forEach(System.out::println);
        if (SecurityContextHolder.getContext().getAuthentication() != null)
            System.out.println(SecurityContextHolder.getContext().getAuthentication().getAuthorities());
    }

    Set<? extends GrantedAuthority> authorities;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Set<GrantedAuthority> authorities) {
        this.authorities = authorities;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getEmail();
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
