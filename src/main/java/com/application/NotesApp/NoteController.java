package com.application.NotesApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@RestController
@SpringBootApplication
@RequestMapping("/notes")
public class NoteController {
    public static void main(String[] args) {
        SpringApplication.run(NoteController.class, args);
    }


    @Autowired
    private NoteService noteService;

    @PostMapping
    public ResponseEntity<Note> createNote(@RequestBody Note note) {
        Note createdNote = noteService.createNote(note);
        return ResponseEntity.ok(createdNote);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Note> editNote(@PathVariable Long id, @RequestBody Note updatedNote) {
        Note editedNote = null;
        try {
            editedNote = noteService.editNote(id, updatedNote);
        } catch (ChangeSetPersister.NotFoundException e) {
            throw new RuntimeException(e);
        }
        return ResponseEntity.ok(editedNote);
    }

    @GetMapping("/category/{categoryId}")
    public List<Note> getAllNotesByCategory(@PathVariable Long categoryId) {
        try {
            return noteService.getAllNotesByCategory(categoryId);
        } catch (ChangeSetPersister.NotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    // Другие методы для работы с записками

}