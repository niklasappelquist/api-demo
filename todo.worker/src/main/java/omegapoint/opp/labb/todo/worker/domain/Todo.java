package omegapoint.opp.labb.todo.worker.domain;

import java.time.Instant;
import java.util.Date;
import java.util.UUID;

public class Todo {
  private String title;
  private boolean completed;

  public Instant getDeadLine() {
    return deadLine;
  }

  private UUID id;

  private Instant deadLine;

  public Todo(String title, boolean completed, UUID id) {
    this.title = title;
    this.completed = completed;
    this.id = id;
    this.deadLine = Instant.now().plusSeconds(14 * 24 * 3600);
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
