package com.example.notemanager.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

public class Note {
    private NoteStatus noteStatus;
    private Long id;

    @NotBlank (message = "Title must not be blank")
    @Size (min = 3, max = 50, message = "Title must be 3-50 characters")
    private String title;
    private String content;
    private LocalDateTime createdAt;

    public Note(){}

    public Note(Long id, String title, String content, LocalDateTime createdAt){
        this.id = id;
        this.title = title;
        this.content = content;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public NoteStatus getNoteStatus() {
        return noteStatus;
    }
}
