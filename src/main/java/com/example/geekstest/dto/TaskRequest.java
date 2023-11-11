package com.example.geekstest.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class TaskRequest {
    private Long id;
    private String title;
    private String description;
    private boolean completed;
    private LocalDate createdAt;

    public TaskRequest() {
    }

    public TaskRequest(Long id, String title, String description, boolean completed, LocalDate createdAt) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.completed = completed;
        this.createdAt = createdAt;
    }
}
