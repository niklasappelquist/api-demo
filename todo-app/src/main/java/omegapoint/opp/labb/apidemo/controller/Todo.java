package omegapoint.opp.labb.apidemo.controller;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.UUID;

@Entity(name="todos")
public class Todo {
    private String title;
    private boolean completed;
    @Id
    private UUID id;

    public Todo(String title, boolean completed, UUID id){
        this.title = title;
        this.completed = completed;
        this.id = id;
    }

    public Todo(){}

    public String getTitle() {
        return title;
    }

    public boolean isCompleted() {
        return completed;
    }

    public UUID getId() {
        return id;
    }
}
