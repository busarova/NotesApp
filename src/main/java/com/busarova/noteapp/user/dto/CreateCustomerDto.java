package com.busarova.noteapp.user.dto;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class CreateCustomerDto {
  
  @NotNull
  @Email
  private String email;
  
  @NotNull
  @Size(min = 6, max = 100)
  private String password;
  
  public CreateCustomerDto(String email, String password) {
    this.email = email;
    this.password = password;
  }
}