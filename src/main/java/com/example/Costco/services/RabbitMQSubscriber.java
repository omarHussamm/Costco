package com.example.Costco.services;

import Config.RabbitMQConfig;
import com.example.Costco.SubmitOrderCommand;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@Service
@Import(RabbitMQConfig.class)
public class RabbitMQSubscriber implements MessageListener{

    private final com.example.Costco.orderService orderService;
    private RabbitMQPublisher producer;

    public RabbitMQSubscriber(com.example.Costco.orderService orderService, RabbitMQPublisher producer) {
        this.orderService = orderService;
        this.producer = producer;
    }

    @RabbitListener(queues = "UserOrderQueue")
    public void receiveUserMessage(String message) {
        // order#id,id,id;userid;total_amount
        String[] checkOrder = message.split("#");
        if(checkOrder[0].equals("order"))
        {
            String[] orderMessage = checkOrder[1].split(";");
                String[] ids = orderMessage[0].split(",");
                String userId = orderMessage[1];
                String totalAmount = orderMessage[2];
                SubmitOrderCommand command = new SubmitOrderCommand(false, ids,"pending", totalAmount,userId);
                int orderId = orderService.executeCommand(command);
                producer.sendOrderTransactionMessage("Transaction#" + orderId + "," + userId + "," + totalAmount);
        }
    }
    @RabbitListener(queues = "TransactionOrderQueue")
    public void receiveTransactionMessage(String message) {
        // approved#orderId || refused#orderId
        String[] transactionOutput = message.split("#");
        if(transactionOutput[0].equals("Approved"))
        {
            int orderId = Integer.parseInt(transactionOutput[1]);
            orderService.updateOrder(orderId);
            System.out.println("orderid: "+ orderId);
            String[] ids = orderService.getProductsFromOrder(orderId);
            String[] products = ids[0].split(",");
            String toBeSend = "Order#";
            for(int i=0;i<products.length;i++)
            {
                System.out.println(products[i]);
                if(i==products.length-1)
                {
                    toBeSend += products[i];
                }
                else
                    toBeSend += products[i] + ";";
            }
            producer.sendOrderProductMessage(toBeSend);
        }
    }
   @RabbitListener(queues = "ProductOrderQueue")
    public void receiveProductMessage(Object message) {
        System.out.println("msg received from product micro-service: "+ message);
    }

    @Override
    public void onMessage(Message message) {
        System.out.println("Consuming Message - " + new String(message.getBody()));
    }
}
