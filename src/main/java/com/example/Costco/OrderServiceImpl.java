package com.example.Costco;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl {

    private List<Order> orders;
    private int nextOrderId;

    public OrderServiceImpl() {
        orders = new ArrayList<>();
        nextOrderId = 1;
    }

//    @Override
//    public int submitOrder(Order order) {
//        int orderId = nextOrderId;
//        order.setId(orderId);
//        orders.add(order);
//        nextOrderId++;
//        return orderId;
//    }

//    @Override
//    public Order getOrderById(int orderId) {
//        for (Order order : orders) {
//            if (order.getId() == orderId) {
//                return order;
//            }
//        }
//        return null;
//    }
}
