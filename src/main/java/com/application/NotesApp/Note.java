package com.application.NotesApp;
public class Note {
    private Long id;
    private String title;
    private String content;
    private Long categoryId;

    // Constructors
    public Note() {
    }

    public Note(Long id, String title, String content, Long categoryId) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.categoryId = categoryId;
    }

    // Getters
    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }
}
