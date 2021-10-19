package com.busarova.noteapp.note.repository;

import com.busarova.noteapp.note.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface NoteRepository extends JpaRepository<Note, Long> {
  
  @Query("SELECT n FROM Note n WHERE n.owner.id = :userId")
  List<Note> findAllByUserId(@Param("userId") Long userId);
  
  @Query("SELECT n FROM Note n WHERE n.owner.id = :userId" +
      " AND lower(n.title) like lower(concat('%', :title,'%'))")
  List<Note> findAllByTitle(@Param("userId") Long userId, @Param("title") String title);
}
