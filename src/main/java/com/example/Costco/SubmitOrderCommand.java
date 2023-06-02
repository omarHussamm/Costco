package com.example.Costco;

import com.example.Costco.services.RabbitMQPublisher;

public class SubmitOrderCommand implements Command {

    private boolean paid;
    private String[]ids;
    private String status;
    private String totalAmount;
    private String userId;

    public SubmitOrderCommand(boolean paid, String[] ids, String status, String totalAmount, String userId) {
        this.paid = paid;
        this.ids = ids;
        this.status = status;
        this.totalAmount = totalAmount;
        this.userId = userId;
    }

    @Override
    public int execute(orderService orderService) {
        return orderService.addOrder(paid, ids, status, totalAmount, userId);
    }
}
