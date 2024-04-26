package com.application.NotesApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteService {

    @Autowired
    private NoteRepository noteRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    public Note createNote(Note note) {
        return noteRepository.save(note);
    }

    public Note editNote(Long id, Note updatedNote) throws ChangeSetPersister.NotFoundException {
        Note note = noteRepository.findById(id).orElseThrow(() -> new ChangeSetPersister.NotFoundException());
        note.setTitle(updatedNote.getTitle());
        note.setContent(updatedNote.getContent());
        note.setCategory(updatedNote.getCategory());
        return noteRepository.save(note);
    }

    public List<Note> getAllNotesByCategory(Long categoryId) throws ChangeSetPersister.NotFoundException {
        Category category = categoryRepository.findById(categoryId).orElseThrow(() -> new ChangeSetPersister.NotFoundException());
        return category.getNotes();
    }
    @Autowired
    public NoteService(NoteRepository noteRepository, CategoryRepository categoryRepository) {
        this.noteRepository = noteRepository;
        this.categoryRepository = categoryRepository;
    }

}