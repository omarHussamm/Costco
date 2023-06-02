package com.example.Costco;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Component
@Service
public class orderService {
    private final List<Command> commandHistory;
    private final orderRepository orderRepository;
    @Autowired
    public orderService(com.example.Costco.orderRepository orderRepository) {
        this.orderRepository = orderRepository;
        this.commandHistory = new ArrayList<>();
    }


    public Object getOrder(int id){
        Object x = orderRepository.getOrder(id);
        System.out.println("HERE : " + x.toString());
        return x;
    }
    public String[] getProductsFromOrder(int id){
        return orderRepository.getProductsFromOrder(id);
    }
    public int addOrder(boolean paid, String[] products, String status, String totalAmount, String userId)
    {
        int orderId = orderRepository.addOrder(paid, products, status, totalAmount, userId);
        return orderId;
    }
    public void updateOrder(int id){
        orderRepository.updateOrder(id);
    }
    public void deleteOrder(int id){
        orderRepository.deleteOrder(id);
    }
    public int executeCommand(Command command)
    {
        commandHistory.add(command);
        return command.execute(this);
    }

    public List<Command> getCommandHistory() {
        return commandHistory;
    }
}
