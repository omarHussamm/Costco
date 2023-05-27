package com.example.Costco;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping(path = "/")
public class orderController {
    private final orderService orderService;
    @Autowired
    public orderController(orderService orderService)
    {
        this.orderService = orderService;
    }
    @GetMapping("/")
    public List<Order> getOrder(){
        return orderService.getOrder();
    }
}
