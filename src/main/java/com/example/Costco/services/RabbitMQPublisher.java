package com.example.Costco.services;

import Config.RabbitMQConfig;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Service;
@Import(RabbitMQConfig.class)

@Service
    public class RabbitMQPublisher {

        @Autowired
        private ConnectionFactory connectionFactory;
         private RabbitTemplate rabbitTemplate;

    public RabbitMQPublisher(RabbitTemplate rabbitTemplate, ConnectionFactory connectionFactory) {
        this.rabbitTemplate = new RabbitTemplate(connectionFactory);
    }
    public void sendOrderProductMessage(String message) {
        rabbitTemplate.convertAndSend("rabbit_mq_exchange", "OrderProductQueue", message);
    }

    public void sendOrderTransactionMessage(String message) {
        rabbitTemplate.convertAndSend("rabbit_mq_exchange", "OrderTransactionQueue", message);
    }

    public void sendOrderUserMessage(String message) {
        rabbitTemplate.convertAndSend("rabbit_mq_exchange", "OrderUserQueue", message);
    }

}

