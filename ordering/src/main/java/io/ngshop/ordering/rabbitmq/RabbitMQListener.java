package io.ngshop.ordering.rabbitmq;

import io.ngshop.ordering.config.Config;
import io.ngshop.ordering.dto.OrderDTO;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;


@Service
public class RabbitMQListener {

    @RabbitListener(queues = Config.queueName)
    public void receiveMessage(final OrderDTO orderDTO) {
        System.out.println(orderDTO.toString());
    }
}
