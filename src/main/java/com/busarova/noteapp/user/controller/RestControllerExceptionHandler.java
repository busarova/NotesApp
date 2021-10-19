package com.busarova.noteapp.user.controller;

import com.busarova.noteapp.user.dto.FieldErrorResponse;
import com.busarova.noteapp.user.service.UserAlreadyExistsException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@ControllerAdvice
public class RestControllerExceptionHandler {
  
  @ExceptionHandler
  @ResponseBody
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public Map<String, List<FieldErrorResponse>> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
    
    return error(exception.getBindingResult().getFieldErrors().stream()
        .map(fieldError -> new FieldErrorResponse(fieldError.getField(), fieldError.getDefaultMessage()))
        .collect(Collectors.toList()));
  }
  
  @ExceptionHandler
  @ResponseBody
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public Map<String, List<FieldErrorResponse>> handleIllegalArgumentException(UserAlreadyExistsException exception) {
    return error(List.of(new FieldErrorResponse("email", exception.getMessage())));
  }
  
  private Map<String, List<FieldErrorResponse>> error(List<FieldErrorResponse> errors) {
    return Collections.singletonMap("errors", errors);
  }
}
