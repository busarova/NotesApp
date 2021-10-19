package com.busarova.noteapp.user.service;

import com.busarova.noteapp.user.UserNotFoundException;
import com.busarova.noteapp.user.dto.CreateCustomerDto;
import com.busarova.noteapp.user.model.AppUser;
import com.busarova.noteapp.user.model.UserRole;
import com.busarova.noteapp.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.Optional;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {
  
  private UserRepository repository;
  private PasswordEncoder passwordEncoder;
  
  @Autowired
  public UserServiceImpl(UserRepository repository, PasswordEncoder passwordEncoder) {
    this.repository = repository;
    this.passwordEncoder = passwordEncoder;
  }
  
  @Override
  public AppUser createCustomer(CreateCustomerDto customerDto) throws UserAlreadyExistsException{
    Optional<AppUser> userOptional = repository.findByEmail(customerDto.getEmail());
    if (userOptional.isPresent()) {
      throw new UserAlreadyExistsException(customerDto.getEmail());
    }
    AppUser user = new AppUser(customerDto.getEmail(), passwordEncoder.encode(customerDto.getPassword()), Set.of(UserRole.CUSTOMER));
    return repository.save(user);
  }
  
  @Override
  public AppUser getUserById(Long userId) {
    Optional<AppUser> user = repository.findById(userId);
    if (user.isPresent()) {
      return user.get();
    } else {
      throw new UserNotFoundException(userId);
    }
  }
  
}
