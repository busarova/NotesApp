package com.busarova.noteapp.user.dto;


import com.busarova.noteapp.user.model.AppUser;
import com.busarova.noteapp.user.model.UserRole;
import lombok.Value;
import java.util.Set;

@Value
public class UserDto {
  
  private Long id;
  private String email;
  private Set<UserRole> roles;
  
  public static UserDto fromUser(AppUser user) {
    return new UserDto(user.getId(), user.getEmail(), user.getRoles());
  }
}
