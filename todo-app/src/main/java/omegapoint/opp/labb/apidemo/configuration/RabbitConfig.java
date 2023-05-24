package omegapoint.opp.labb.apidemo.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.amqp.core.Queue;
import omegapoint.opp.labb.apidemo.repository.RabbitSender;

@Configuration
public class RabbitConfig {

  @Bean
  public Queue queue() {
    return new Queue("spring-boot", false);
  }

  @Bean
  public RabbitSender sender() {
    return new RabbitSender();
  }
}
