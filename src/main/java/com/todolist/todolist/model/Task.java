package com.todolist.todolist.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Task {

    @Id
    // Gera um valor automaticamente
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Geração automática do ID
    private Long id;

    private String description;
    // Status da tarefa
    private String status;

    public Task() {}

    public Task(String description, String status) {
        this.description = description;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}