package omegapoint.opp.labb.todo.worker.controller;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class TodoController {
  @PostMapping("/")
  public ResponseEntity ProcessTodo(@RequestBody ApiTodoDTO todo) {
    var domainTodo = DTOMapper.toDomain(todo);
    try {
      String contents = String.format("%s, %s, %s", domainTodo.getTitle(), domainTodo.getId(),
          domainTodo.getDeadLine());
      BufferedWriter writer = new BufferedWriter(
          new FileWriter(String.format("Todo_%s.csv", domainTodo.getId().toString())));
      writer.write(contents);
      writer.close();
      return ResponseEntity.ok().build();
    } catch (IOException e) {
      return ResponseEntity.internalServerError().build();
    }
  }
}
