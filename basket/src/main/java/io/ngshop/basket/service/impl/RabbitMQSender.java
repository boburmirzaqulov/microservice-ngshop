package io.ngshop.basket.service.impl;

import io.ngshop.basket.dto.BasketCheckout;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static io.ngshop.basket.config.Config.exchange;
import static io.ngshop.basket.config.Config.routingKey;

@Service
public class RabbitMQSender {

    @Autowired
    private AmqpTemplate amqpTemplate;


    public void send(BasketCheckout basketResponse) {
        amqpTemplate.convertAndSend(exchange, routingKey, basketResponse);
    }
}
