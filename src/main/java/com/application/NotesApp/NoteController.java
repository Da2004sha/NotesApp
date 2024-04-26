package com.application.NotesApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notes")
public class NoteController {

    @Autowired
    private NoteRepository NoteRepository;

    @GetMapping
    public List<Note> getAllNotes() {
        return NoteRepository.findAll();
    }

    @PostMapping
    public Note createNote(@RequestBody Note note) {
        return NoteRepository.save(note);
    }

    @PutMapping("/{id}")
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

