package com.busarova.noteapp.authentication;

import com.busarova.noteapp.user.model.AppUser;
import com.busarova.noteapp.user.model.UserRole;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

public class AppUserDetails extends User {
  
  private static final String ROLE_PREFIX = "ROLE_";
  private final Long userId;
  
  public AppUserDetails(AppUser user) {
    super(user.getEmail(), user.getPassword(), createAuthorities(user.getRoles()));
    this.userId = user.getId();
  }
  public Long getUserId() {
    return userId;
  }
  private static Collection<SimpleGrantedAuthority> createAuthorities(Set<UserRole>
      roles) {
    return roles.stream()
        .map(userRole -> new SimpleGrantedAuthority(ROLE_PREFIX + userRole.name()))
        .collect(Collectors.toSet());
  }
}
