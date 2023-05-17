package omegapoint.opp.labb.todo.worker.controller;

import omegapoint.opp.labb.todo.worker.domain.Todo;

public class DTOMapper {
  public static Todo toDomain(ApiTodoDTO todo) {
    return new Todo(todo.getTitle(), todo.isCompleted(), todo.getId());
  }
}
