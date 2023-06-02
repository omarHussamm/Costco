package com.example.Costco;


import jakarta.persistence.*;

import java.util.List;
@Entity(name = "orders")
public class Order {
	@Id
//	@SequenceGenerator(
//			name = "order_sequence",
//			sequenceName = "order_sequence",
//			allocationSize = 1
//	)
	@GeneratedValue(
			strategy = GenerationType.IDENTITY
//			generator = "order_sequence"
	)
	private int id;
	@Column
	private String user_id;
	@Column(nullable = true)
	private List<String> products;
	@Column
	private String status;
	@Column
	private boolean paid;
	@Column
	private String totalAmount;

//	public Order() {
//	}

//	public Order(int id, int userId , List<String> products, String status, boolean paid) {
//		this.id = id;
//		this.user_id = userId;
//		this.products = products;
//		this.status = status;
//		this.paid = paid;
//	}
//	public Order(int id, int userId, String status, boolean paid) {
//		this.id = id;
//		this.user_id = userId;
//		this.status = status;
//		this.paid = paid;
//	}
//	public Order(int userId, String status, boolean paid) {
//		this.user_id = userId;
//		this.status = status;
//		this.paid = paid;
//	}


	public int getId() {
		return id;
	}

	public String getUser_id() {
		return user_id;
	}

	public List<String> getProducts() {
		return products;
	}

	public String getStatus() {
		return status;
	}

	public boolean isPaid() {
		return paid;
	}

	public String getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(String totalAmount) {
		this.totalAmount = totalAmount;
	}
}


