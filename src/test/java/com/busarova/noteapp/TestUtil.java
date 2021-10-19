package com.busarova.noteapp;

import com.busarova.noteapp.note.dto.CreateNoteDto;
import com.busarova.noteapp.note.model.Note;
import com.busarova.noteapp.user.model.AppUser;
import com.busarova.noteapp.user.model.UserRole;

import java.util.HashSet;

public class TestUtil {
  
  public static final String TEST_EMAIL = "r.busarova@tests.com";
  
  public static final String TEST_TITLE = "test-title";
  public static final String TEST_DESCRIPTION = "The actual note";
  
  public static AppUser createTestUser() {
    HashSet<UserRole> roles = new HashSet<>();
    roles.add(UserRole.CUSTOMER);
    return new AppUser(TEST_EMAIL, "password", roles);
  }
  
  public static Note createTestNote(AppUser owner) {
    return new Note(owner, TEST_TITLE, TEST_DESCRIPTION);
  }
  
  public static Note createNoteWithParams(AppUser owner, String title, String description) {
    return new Note(owner, title, description);
  }
  
  public static CreateNoteDto createTestNoteDto() {
    return new CreateNoteDto(TEST_TITLE, TEST_DESCRIPTION);
  }
}
