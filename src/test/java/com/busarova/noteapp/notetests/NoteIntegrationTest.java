package com.busarova.noteapp.notetests;

import com.busarova.noteapp.TestUtil;
import com.busarova.noteapp.note.model.Note;
import com.busarova.noteapp.note.repository.NoteRepository;
import com.busarova.noteapp.user.model.AppUser;
import com.busarova.noteapp.user.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles({"test"})
public class NoteIntegrationTest {
  
  @Autowired
  private NoteRepository noteRepository;
  
  @Autowired
  private UserRepository userRepository;
  
  @PersistenceContext
  private EntityManager entityManager;
  
  @Autowired
  private JdbcTemplate jdbcTemplate;
  
  @Test
  public void testFindAllByUserId() {
    
    AppUser owner = userRepository.save(TestUtil.createTestUser());
    noteRepository.save(TestUtil.createTestNote(owner));
  
    List<Note> notes = noteRepository.findAllByUserId(owner.getId());
    assertThat(notes).isNotEmpty();
    assertThat(notes.size() == 1);
    assertThat(notes.get(0).getTitle()).isEqualTo(TestUtil.TEST_TITLE);
    assertThat(notes.get(0).getDescription()).isEqualTo(TestUtil.TEST_DESCRIPTION);
  
  }
  
  @Test
  public void testFindByTitle() {
  
    AppUser owner = userRepository.save(TestUtil.createTestUser());
  
    List<Note> notes = new ArrayList<>();
    notes.add(TestUtil.createTestNote(owner));
    notes.add(TestUtil.createNoteWithParams(owner, TestUtil.TEST_TITLE, "note with same title, different description, same user"));
    notes.add(TestUtil.createNoteWithParams(owner,"different title", "note with a different title for same user"));
    noteRepository.saveAll(notes);
  
    List<Note> result = noteRepository.findAllByTitle(owner.getId(), TestUtil.TEST_TITLE);
    assertThat(result).isNotNull();
    assertThat(result.size() == 2);
    assertThat(result.get(0).getTitle()).isEqualTo(TestUtil.TEST_TITLE);
    assertThat(result.get(0).getDescription()).isEqualTo(TestUtil.TEST_DESCRIPTION);
    assertThat(result.get(1).getTitle()).isEqualTo(TestUtil.TEST_TITLE);
    assertThat(result.get(1).getDescription()).isEqualTo("note with same title, different description, same user");
  }
  
  @Test
  public void testSaveNote() {
  
    AppUser owner = userRepository.save(TestUtil.createTestUser());
    noteRepository.save(TestUtil.createTestNote(owner));
    
    assertThat(noteRepository.count()).isEqualTo(1L);
    assertThat(jdbcTemplate.queryForObject("SELECT count(*) FROM note",
        Long.class)).isEqualTo(1L);
    assertThat(jdbcTemplate.queryForObject("SELECT title FROM note",
        String.class)).isEqualTo(TestUtil.TEST_TITLE);
    assertThat(jdbcTemplate.queryForObject("SELECT description FROM note",
        String.class)).isEqualTo(TestUtil.TEST_DESCRIPTION);
  }
  

}
