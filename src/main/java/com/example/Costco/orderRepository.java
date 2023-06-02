package com.example.Costco;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface orderRepository extends JpaRepository<Order, Integer> {
    @Query(value = "select get_order(?1)", nativeQuery = true)
    Object getOrder( int id);
    @Query(value = "select get_products_from_order(?1)", nativeQuery = true)
    String[] getProductsFromOrder(int id);

//    @Query(value = "select add_order(?1,?2,?3)", nativeQuery = true)
//    void addOrder(String userId, String status, boolean paid);
    @Query(value = "select add_order(?1,?2,?3,?4,?5)", nativeQuery = true)
    int addOrder(boolean paid, String[] products, String status, String totalAmount, String userId);
    @Query(value = "select update_order(?1)", nativeQuery = true)
    void updateOrder(int id);
    @Query(value = "select delete_order(?1)", nativeQuery = true)
    void deleteOrder(int id);
}
