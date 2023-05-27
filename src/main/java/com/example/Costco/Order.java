package com.example.Costco;


import java.util.List;

public class Order {
	private long id;
	private long user_id;
	//order items like
	private List<Product> products;
	private String status;
	private boolean paid;

	public Order(int id, int userId, List<Product> products, String status, boolean paid) {
		this.id = id;
		this.user_id = userId;
		this.products = products;
		this.status = status;
		this.paid = paid;
	}

	public long getId() {
		return id;
	}

	public long getUserId() {
		return user_id;
	}

	public List<Product> getProducts() {
		return products;
	}

	public String getStatus() {
		return status;
	}

	public double getTotal() {
		return products.stream().mapToDouble(Product::getPrice).sum();
	}

	public void updateOrderStatus(Order order, String event) {
		String currentStatus = order.getStatus();

		// Check the current status and the event to determine the new status
		String newStatus;
		switch(currentStatus) {
			case "Pending":
				if (event.equals("OrderConfirmed")) {
					newStatus = "Processing";
				} else {
					newStatus = currentStatus;
				}
				break;
			case "Processing":
				if (event.equals("OrderShipped")) {
					newStatus = "Shipped";
				} else {
					newStatus = currentStatus;
				}
				break;
			case "Shipped":
				if (event.equals("OrderDelivered")) {
					newStatus = "Delivered";
				} else {
					newStatus = currentStatus;
				}
				break;
			default:
				newStatus = currentStatus;
		}

		// Update the order status if it has changed
		if (!newStatus.equals(currentStatus)) {
			order.setStatus(newStatus);
		}
	}

	public void setStatus(String event) {
		switch (event) {
			case "OrderConfirmed":
				this.status = "Processing";
				break;
			case "OrderShipped":
				this.status = "Shipped";
				break;
			case "OrderDelivered":
				this.status = "Delivered";
				break;
			case "OrderCanceled":
				this.status = "Canceled";
				break;
			case "OrderRefunded":
				this.status = "Refunded";
				break;
			case "OrderReturned":
				this.status = "Returned";
				break;
			default:
				// handle invalid event
				throw new IllegalArgumentException("Invalid event: " + event);
		}
	}

	public boolean getpaid() {
		return paid;
	}

	public void setpaid(boolean paid) {
		this.paid = paid;
	}

	public void setId(int orderId) {
		// TODO Auto-generated method stub
		this.id=orderId;
	}

}


