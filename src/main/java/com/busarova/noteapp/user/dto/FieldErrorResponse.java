package com.busarova.noteapp.user.dto;

import lombok.Value;

@Value
public class FieldErrorResponse {
  private String fieldName;
  private String errorMessage;
}