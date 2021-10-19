package com.busarova.noteapp.note.controller;

import com.busarova.noteapp.authentication.AppUserDetails;
import com.busarova.noteapp.note.dto.CreateNoteDto;
import com.busarova.noteapp.note.dto.NoteDto;
import com.busarova.noteapp.note.model.Note;
import com.busarova.noteapp.note.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/notes")
public class NoteController {
 
  private NoteService service;
  
  @Autowired
  public NoteController(NoteService service) {
    this.service = service;
  }
  
  @GetMapping
  public List<NoteDto> getMyNotes(@AuthenticationPrincipal AppUserDetails userDetails) {
    List<Note> notes = service.getNotesByUserId(userDetails.getUserId());
    return notes.stream()
        .map(NoteDto::fromNote)
        .collect(Collectors.toList());
  }
  
  @GetMapping("/title")
  public List<NoteDto> findNotesByTitle(@AuthenticationPrincipal AppUserDetails userDetails, @RequestParam String title) {
    List<Note> notes = service.getNotesByTitle(userDetails.getUserId(), title);
    return notes.stream()
        .map(NoteDto::fromNote)
        .collect(Collectors.toList());
  }
  
  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public NoteDto createNote(@AuthenticationPrincipal AppUserDetails userDetails, @Valid @RequestBody CreateNoteDto noteDto){
    Note note = service.createNote(userDetails.getUserId(), noteDto);
    return NoteDto.fromNote(note);
  }
  
  @DeleteMapping
  public void deleteNote(@PathVariable Long id){
    service.deleteNote(id);
  }
}
