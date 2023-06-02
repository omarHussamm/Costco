package com.example.Costco;

import com.example.Costco.services.RabbitMQPublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
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
    @GetMapping("getOrder/{id}")
    public Object getOrder(@PathVariable("id") int id){
        return orderService.getOrder(id);
    }

//    @PostMapping("addOrder")
//    public void addOrder(@RequestBody() Order order){
//        String userId = order.getUser_id();
//        String status = order.getStatus();
//        boolean paid = order.isPaid();
//        orderService.addOrder(userId, status, paid);
//    }
//    @PutMapping("updateOrder/{id}/{newStatus}")
//    public void updateOrder(@PathVariable("id") int id,@PathVariable("newStatus") String newStatus)
//    {
//        orderService.updateOrder(id, newStatus);
//    }
    @DeleteMapping("deleteOrder/{id}")
    public void deleteOrder(@PathVariable("id") int id)
    {
        orderService.deleteOrder(id);
    }
}
