package omegapoint.opp.labb.apidemo.controller;

import omegapoint.opp.labb.apidemo.repository.TodoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("todos")
public class TodoController {
  private TodoRepository todoRepository;

  public TodoController(TodoRepository todoRepository) {
    this.todoRepository = todoRepository;
  }

  @GetMapping("/")
  public ResponseEntity<List<Todo>> GetTodos() {
    try {
      var todos = todoRepository.findAll();
      return ResponseEntity.ok(todos);
    } catch (Exception e) {
      System.out.println(e);
      return ResponseEntity.internalServerError().build();
    }
  }

  @PostMapping("/")
  public ResponseEntity AddTodo(@RequestBody Todo todo) {
    try {
      todoRepository.save(new Todo(todo.getTitle(), todo.isCompleted(), UUID.randomUUID()));
      return ResponseEntity.ok().build();
    } catch (Exception e) {
      System.out.println(e);
      return ResponseEntity.internalServerError().build();
    }
  }
}
