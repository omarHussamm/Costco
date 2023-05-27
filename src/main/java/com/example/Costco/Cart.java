//package com.example.Costco;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class Cart {
// private int userId;
// private List<Product> products;
//
// public Cart(int userId) {
//     this.userId = userId;
//     this.products = new ArrayList<>();
// }
//
// public int getUserId() {
//     return userId;
// }
//
// public List<Product> getProducts() {
//     return products;
// }
//
// public void addProduct(Product product) {
//     products.add(product);
// }
//
// public void removeProduct(Product product) {
//     products.remove(product);
// }
//
// public double getTotal() {
//     return products.stream().mapToDouble(Product::getPrice).sum();
// }
//}
package com.example.Costco;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private int userId;
    private List<Product> products;

    public Cart(int userId, ArrayList<Product> products) {
        this.userId = userId;
        this.products = products;
    }

    public int getUserId() {
        return userId;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void removeProduct(Product product) {
        products.remove(product);
    }

    public double getTotal() {
        double total = 0.0;
        for (Product product : products) {
            total += product.getPrice() * product.getQuantity();
        }
        return total;
    }
}

