package com.example.hellospring.task;

public class Task {
    private int id;
    private String title;

    public Task(int id, String title) {
        this.id = id;
        this.title = title;
    }

    // Getter と Setter
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
}