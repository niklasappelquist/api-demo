package omegapoint.opp.labb.apidemo.repository;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

public class RabbitSender {

  @Autowired
  private RabbitTemplate rabbitTemplate;
  @Autowired
  private Queue queue;

  public void send(String message) {
    rabbitTemplate.convertAndSend(queue.getName(), message);
  }
}
