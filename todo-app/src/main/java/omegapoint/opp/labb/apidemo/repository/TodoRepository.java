package omegapoint.opp.labb.apidemo.repository;

import omegapoint.opp.labb.apidemo.controller.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TodoRepository extends JpaRepository<Todo, UUID> {

}
