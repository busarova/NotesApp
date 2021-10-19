package com.busarova.noteapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Import;

@SpringBootApplication
public class NoteappApplication {
  
  public static void main(String[] args) {
    SpringApplication.run(NoteappApplication.class, args);
  }
  
}
