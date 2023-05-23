package omegapoint.opp.labb.apidemo.controller;

import omegapoint.opp.labb.apidemo.repository.TodoRepository;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.sound.midi.Receiver;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("todos")
public class TodoController {

  private TodoRepository todoRepository;
  private RabbitTemplate rabbitTemplate;

  public TodoController(TodoRepository todoRepository, RabbitTemplate rabbitTemplate) {
    this.todoRepository = todoRepository;
    this.rabbitTemplate = rabbitTemplate;
  }

  @GetMapping("/")
  public ResponseEntity<List<Todo>> GetTodos() {
    try {
      var todos = todoRepository.findAll();
      rabbitTemplate.convertAndSend("spring-boot", "Great success!");
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
