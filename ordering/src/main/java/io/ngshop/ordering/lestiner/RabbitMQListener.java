package io.ngshop.ordering.lestiner;

import io.ngshop.ordering.config.Config;
import io.ngshop.ordering.dto.OrderDTO;
import io.ngshop.ordering.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class RabbitMQListener {
    private final OrderService orderService;
    @RabbitListener(queues = Config.queueName)
    public void requestMessage(@Payload final OrderDTO customMessage){
        orderService.addOrder(customMessage);

    }
}
