package com.product.security;

import com.product.entity.User;
import lombok.Data;
import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;


public class UserPrincipal implements UserDetails {
    private User user;
   public   UserPrincipal(User user)
     {
        this.user=user;
     }
//      @Autowired
//    private User user;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities()
    {
        return List.of(new SimpleGrantedAuthority("ROLE_SELLER"));
    }

    @Override
    public @Nullable String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true; // false
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
