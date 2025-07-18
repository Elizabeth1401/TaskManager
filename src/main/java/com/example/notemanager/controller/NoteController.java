package com.example.notemanager.controller;


import com.example.notemanager.model.Note;
import com.example.notemanager.model.NoteStatus;
import com.example.notemanager.service.NoteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/notes")
public class NoteController {
    @Autowired
    private NoteService noteService;

    @GetMapping
    public List<Note> getAllNotes(@RequestParam(required = false)NoteStatus noteStatus){
      if (noteStatus != null){
          return noteService.getNotesByStatus(noteStatus);
      }
       return noteService.getNotes();
    }

    @PostMapping
    public Note createNote(@Valid @RequestBody Note note){
        return noteService.addNotes(note);
    }

    @DeleteMapping("/{id}")
    public void deleteNote(@RequestBody Note note){
        boolean removed = noteService.deleteNote(note.getId());
        if (!removed){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Note not found");
        }
    }
}
