package omegapoint.opp.labb.todo.worker.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class TodoController {
    @PostMapping("/")
    public ResponseEntity ProcessTodo(@RequestBody ApiTodoDTO todo){
        var domainTodo = DTOMapper.toDomain(todo);
        return ResponseEntity.ok().build();
    }
}
