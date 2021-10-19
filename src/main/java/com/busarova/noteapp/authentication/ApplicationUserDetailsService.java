package com.busarova.noteapp.authentication;

import com.busarova.noteapp.user.model.AppUser;
import com.busarova.noteapp.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ApplicationUserDetailsService implements UserDetailsService {
  
  private UserRepository userRepository;
  
  @Autowired
  public ApplicationUserDetailsService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }
  
  @Override
  public AppUserDetails loadUserByUsername(String username) {
    AppUser user = userRepository.findByEmail(username)
  .orElseThrow(() -> new UsernameNotFoundException(
        String.format("User with email %s could not be found",
            username)));
    return new AppUserDetails(user);
  }
}
