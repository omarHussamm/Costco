package com.example.Costco;

import com.example.Costco.services.RabbitMQPublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/")
public class orderController {
    private final orderService orderService;
    private RabbitMQPublisher producer;

    @Autowired
    public orderController(orderService orderService , RabbitMQPublisher producer)
    {
        this.orderService = orderService;
        this.producer = producer;
    }
    @GetMapping("/")
    public List<Order> getOrder(){
        return orderService.getOrder();
    }
    @GetMapping("/try")
    public ResponseEntity<String> sendMessageFromOrderToUser(@RequestParam("message") String message){
        producer.sendOrderProductMessage(message);
        System.out.println("message is "+message);
        return ResponseEntity.ok("Message sent to RabbitMQ ...");
    }
}
