package com.application.NotesApp;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "category")
    private List<Note> notes;

    public List<Note> getNotes() {
        return null;

    }

    public Category() {
    }

    public Category(String name) {
        this.name = name;
    }

}