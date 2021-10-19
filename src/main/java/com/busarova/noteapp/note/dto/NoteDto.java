package com.busarova.noteapp.note.dto;

import com.busarova.noteapp.note.model.Note;
import lombok.Value;

@Value
public class NoteDto {
  
  private Long createdDate;
  private String title;
  private String description;
  
  public static NoteDto fromNote (Note note) {
    return new NoteDto(note.getCreatedDate(), note.getTitle(), note.getDescription());
  }
  
}
