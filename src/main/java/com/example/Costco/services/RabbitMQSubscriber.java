package com.example.Costco.services;

import Config.RabbitMQConfig;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Import(RabbitMQConfig.class)
public class RabbitMQSubscriber implements MessageListener{
    @RabbitListener(queues = "UserOrderQueue")
    public void receiveUserMessage(Object message) {
        System.out.println("msg received from user micro-service: "+message);
    }
    @RabbitListener(queues = "TransactionOrderQueue")
    public void receiveTransactionMessage(Object message) {
        System.out.println("msg received from transaction micro-service: "+message);
    }
   @RabbitListener(queues = "ProductOrderQueue")
    public void receiveProductMessage(Object message) {
        System.out.println("msg received from product micro-service: "+message);
    }

    @Override
    public void onMessage(Message message) {
        System.out.println("Consuming Message - " + new String(message.getBody()));
    }
}
