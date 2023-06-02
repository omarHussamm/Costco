//package com.example.Costco;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class Cart {
//    private int userId;
//    private List<String> products;
//
//    public Cart(int userId, ArrayList<String> products) {
//        this.userId = userId;
//        this.products = products;
//    }
//
//    public int getUserId() {
//        return userId;
//    }
//
//    public List<String> getProducts() {
//        return products;
//    }
//
//    public void addProduct(String product) {
//        products.add(product);
//    }
//
//    public void removeProduct(String product) {
//        products.remove(product);
//    }
//
//    public double getTotal() {
//        double total = 0.0;
//        for (Product product : products) {
//            total += product.getPrice() * product.getQuantity();
//        }
//        return total;
//    }
//}
//
