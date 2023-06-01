package com.example.Costco;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class orderService {
    public List<Order> getOrder(){
        Product x = new Product(1,"Laptop","macbook", 1000);
        Product y = new Product(2,"iPhone","12 pro", 1300);
        List<Product> products = new ArrayList<>();
        products.add(x);
        products.add(y);
        return List.of(
                new Order(1,
                        100,
                        products,
                        "pending",
                        false)
        );
    }
    public void addToCart(Product product){
        Product x = new Product(1,"Laptop","macbook", 1000);
        Product y = new Product(2,"iPhone","12 pro", 1300);
        ArrayList<Product> products = new ArrayList<>();
        Cart cart = new Cart(1,products);
        cart.addProduct(product);
    }
    public void removeFromCart(Product product){
        Product x = new Product(1,"Laptop","macbook", 1000);
        Product y = new Product(2,"iPhone","12 pro", 1300);
        ArrayList<Product> products = new ArrayList<>();
        Cart cart = new Cart(1,products);
        cart.removeProduct(product);
    }
}
