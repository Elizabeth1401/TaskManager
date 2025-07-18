package com.example.notemanager.service;

import com.example.notemanager.exception.NoteNotFoundException;
import com.example.notemanager.model.Note;
import com.example.notemanager.model.NoteStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class NoteService {
    private final List<Note> notes = new ArrayList<>();
    private long idCounter = 1;

    public List<Note> getNotes(){
        return notes;
    }
    public Note addNotes (Note note){
        note.setId(idCounter++);
        notes.add(note);
        return note;
    }

    public boolean deleteNote(Long id){
        return notes.removeIf(note -> note.getId().equals(id));
    }

    public List<Note> getNotesByStatus(NoteStatus noteStatus){
        return notes.stream()
                .filter(note -> note.getNoteStatus() == noteStatus)
                .collect(Collectors.toList());
    }

    public Note getNoteById(Long id){
        return notes.stream()
                .filter(note -> note.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new NoteNotFoundException(id));
    }
}
