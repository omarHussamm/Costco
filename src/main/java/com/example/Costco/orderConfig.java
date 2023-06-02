//package com.example.Costco;
//
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Configuration
//public class orderConfig {
//    @Bean
//    CommandLineRunner commandLineRunner(orderRepository repository){
//        return args ->{
//            List<String> products = new ArrayList<>();
//            products.add("iphone");
//            products.add("laptop");
//            products.add("ayhaga");
//            Order tmp = new Order(1,
//                    100,
//                    products,
//                    "pending",
//                    false);
//            Order tmpTwo = new Order(2,
//                    200,
//                    products,
//                    "pending",
//                    false);
//            repository.saveAll(
//                    List.of(tmp, tmpTwo)
//            );
//        };
//    }
//}
