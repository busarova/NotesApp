package com.busarova.noteapp.user.repository;

import com.busarova.noteapp.user.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<AppUser, Long> {
  
  Optional<AppUser> findByEmail(String email);
  
}
