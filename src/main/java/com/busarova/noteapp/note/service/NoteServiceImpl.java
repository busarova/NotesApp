package com.busarova.noteapp.note.service;

import com.busarova.noteapp.note.dto.CreateNoteDto;
import com.busarova.noteapp.note.model.Note;
import com.busarova.noteapp.note.repository.NoteRepository;
import com.busarova.noteapp.user.UserNotFoundException;
import com.busarova.noteapp.user.model.AppUser;
import com.busarova.noteapp.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class NoteServiceImpl implements NoteService {
  
  private NoteRepository repository;
  private UserService userService;
  
  @Autowired
  public NoteServiceImpl(NoteRepository repository, UserService userService) {
    this.repository = repository;
    this.userService = userService;
  }
  
  @Override
  public List<Note> getNotesByUserId(Long userId) {
    return repository.findAllByUserId(userId);
  }
  
  @Override public List<Note> getNotesByTitle(Long userId, String title) {
    return repository.findAllByTitle(userId, title);
  }
  
  @Override
  public Note createNote(Long userId, CreateNoteDto noteDto) {
    AppUser user = userService.getUserById(userId);
    if (user == null) {
      throw new UserNotFoundException(userId);
    }
    Note note = new Note(user, noteDto.getTitle(), noteDto.getDescription());
    return repository.save(note);
  }
  
  @Override public void deleteNote(Long id) {
    Optional<Note> note = repository.findById(id);
    note.ifPresent(value -> repository.delete(value));
  }
}
