package com.busarova.noteapp.note.service;

import com.busarova.noteapp.note.dto.CreateNoteDto;
import com.busarova.noteapp.note.model.Note;

import java.util.List;

public interface NoteService {
  
  List<Note> getNotesByUserId(Long userId);
  
  List<Note> getNotesByTitle(Long userId, String title);
  
  Note createNote(Long userId, CreateNoteDto noteDto);
  
  void deleteNote(Long id);
}
