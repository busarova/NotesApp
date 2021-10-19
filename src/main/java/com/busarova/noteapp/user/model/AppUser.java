package com.busarova.noteapp.user.model;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "app_user")
public class AppUser {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  
  @Column(unique = true)
  private String email;
  
  private String password;
  
  @ElementCollection(fetch = FetchType.EAGER)
  @Enumerated(EnumType.STRING)
  @NotNull
  private Set<UserRole> roles;
  
  public AppUser() {
  }
  
  public AppUser(String email, String password, Set<UserRole> roles) {
    this.email = email;
    this.password = password;
    this.roles = roles;
  }
  
  public Long getId() {
    return id;
  }
  
  public void setId(Long id) {
    this.id = id;
  }
  
  public String getEmail() {
    return email;
  }
  
  public void setEmail(String email) {
    this.email = email;
  }
  
  public String getPassword() {
    return password;
  }
  
  public void setPassword(String password) {
    this.password = password;
  }
  
  public Set<UserRole> getRoles() {
    return roles;
  }
  
  public void setRoles(Set<UserRole> roles) {
    this.roles = roles;
  }
}
