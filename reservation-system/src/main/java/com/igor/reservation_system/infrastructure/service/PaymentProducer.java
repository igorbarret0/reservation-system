package com.igor.reservation_system.infrastructure.service;

import com.igor.reservation_system.core.entities.Payment;
import com.igor.reservation_system.infrastructure.configurations.RabbitMQConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.stereotype.Component;

@Component
public class PaymentProducer {

    private RabbitTemplate rabbitTemplate;

    public PaymentProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;}

    public void processPayment(Payment payment) {

        rabbitTemplate.setMessageConverter(new Jackson2JsonMessageConverter());

        rabbitTemplate.convertAndSend(
                RabbitMQConfig.PAYMENT_EXCHANGE,
                RabbitMQConfig.PAYMENT_ROUTING_KEY,
                payment
        );
    }
}
