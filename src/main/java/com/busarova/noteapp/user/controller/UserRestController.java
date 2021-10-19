package com.busarova.noteapp.user.controller;

import com.busarova.noteapp.authentication.AppUserDetails;
import com.busarova.noteapp.user.dto.CreateCustomerDto;
import com.busarova.noteapp.user.dto.UserDto;
import com.busarova.noteapp.user.model.AppUser;
import com.busarova.noteapp.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserRestController {
  
  private UserService service;
  
  @Autowired
  public UserRestController(UserService service) {
    this.service = service;
  }
  
  @GetMapping("/me")
  public UserDto currentUser(@AuthenticationPrincipal AppUserDetails userDetails) {
    AppUser user = service.getUserById(userDetails.getUserId());
    return UserDto.fromUser(user);
  }
  
  @PostMapping("/create")
  @ResponseStatus(HttpStatus.CREATED)
  public UserDto createCustomer(@RequestBody @Valid CreateCustomerDto customer){
    AppUser user = service.createCustomer(customer);
    return UserDto.fromUser(user);
  }
}