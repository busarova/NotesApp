package com.busarova.noteapp.note.model;

import com.busarova.noteapp.user.model.AppUser;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Note {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  
  @ManyToOne
  private AppUser owner;
  
  @Column(name = "created_date")
  private Long createdDate;
  private String title;
  private String description;
  
  public Note() {
    this.createdDate = System.currentTimeMillis();
  }
  
  public Note(AppUser user, String title, String description) {
    
    this.owner = user;
    this.title = title;
    this.description = description;
    this.createdDate = System.currentTimeMillis();
  }
  
  public Long getId() {
    return id;
  }
  
  public void setId(Long id) {
    this.id = id;
  }
  
  public AppUser getOwner() {
    return owner;
  }
  
  public void setOwner(AppUser owner) {
    this.owner = owner;
  }
  
  public Long getCreatedDate() {
    return createdDate;
  }
  
  public void setCreatedDate(Long createdDate) {
    this.createdDate = createdDate;
  }
  
  public String getTitle() {
    return title;
  }
  
  public void setTitle(String title) {
    this.title = title;
  }
  
  public String getDescription() {
    return description;
  }
  
  public void setDescription(String description) {
    this.description = description;
  }
}
