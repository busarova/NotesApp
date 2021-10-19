package com.busarova.noteapp.note.dto;

import lombok.Value;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Value
public class CreateNoteDto {
  
  @NotNull
  private String title;
  
  @NotNull
  @Size(min = 1, max = 1000)
  private String description;
}
