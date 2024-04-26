package com.application.NotesApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;


@RestController
@RequestMapping("/api/notes")
public class NoteController {

    @Autowired
    private NoteRepository NoteRepository;

    @GetMapping
    public List<Note> getAllNotes() {
        return NoteRepository.findAll();
    }

    @PostMapping("/create")
    public Note createNote(@RequestBody Note note) {
        return NoteRepository.save(note);
    }


    @PutMapping("/update/{id}")
    public Note updateNote(@PathVariable Long id, @RequestBody Note updatedNote) {
        Note note = NoteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Note not found"));
        note.setTitle(updatedNote.getTitle());
        note.setContent(updatedNote.getContent());
        note.setCategory(updatedNote.getCategory());
        return NoteRepository.save(note);
    }


    @GetMapping("/category/{category}")
    public List<Note> getNotesByCategory(@PathVariable String category) {
        return NoteRepository.findByCategory(category);
    }
}

