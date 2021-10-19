package com.busarova.noteapp.user.service;

import com.busarova.noteapp.user.dto.CreateCustomerDto;
import com.busarova.noteapp.user.dto.UserDto;
import com.busarova.noteapp.user.model.AppUser;

public interface UserService {
  
  AppUser createCustomer(CreateCustomerDto customerDto);
  
  AppUser getUserById(Long userId);
}
