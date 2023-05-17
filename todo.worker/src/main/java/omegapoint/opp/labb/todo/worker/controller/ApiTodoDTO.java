package omegapoint.opp.labb.todo.worker.controller;

import java.util.UUID;

public class ApiTodoDTO {
    private String title;
    private boolean completed;
    private UUID id;

    public ApiTodoDTO(String title, boolean completed, UUID id) {
        this.title = title;
        this.completed = completed;
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}