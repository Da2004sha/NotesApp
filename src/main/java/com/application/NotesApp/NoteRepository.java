package com.application.NotesApp;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

import java.util.List;

public interface NoteRepository extends JpaRepository<Note, Long> {
    List<Note> findByCategory(String category);
}

