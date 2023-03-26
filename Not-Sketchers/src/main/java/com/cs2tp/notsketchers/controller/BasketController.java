package com.cs2tp.notsketchers.controller;


import com.cs2tp.notsketchers.entities.CustomerEntity;
import com.cs2tp.notsketchers.entities.OrderStatus;
import com.cs2tp.notsketchers.entities.OrdersEntity;
import com.cs2tp.notsketchers.entities.ProductEntity;
import com.cs2tp.notsketchers.repository.OrdersRepository;
import com.cs2tp.notsketchers.repository.ProductRepository;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Timestamp;
import java.util.List;

@Controller
public class BasketController {
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private OrdersRepository ordersRepository;

    @GetMapping("/basket")
    public String returnBasket() {
        return "basket";
    }

    @PostMapping("/checkout")
    public String checkout(@RequestParam("data") String jsonData) {
        if (this.getLoggedInUser() == null) {
            return "redirect:basket?fail=notLoggedIn";
        }

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            List<BasketDataCollector> basketData = objectMapper.readValue(jsonData, new TypeReference<List<BasketDataCollector>>() {});

            for (BasketDataCollector basketDataCollector : basketData) {
                ProductEntity product = this.productRepository.findById(basketDataCollector.id).get();
                product.setProductStockCount(product.getStockCount() - basketDataCollector.number_of_items);
                this.productRepository.save(product);

                OrdersEntity ordersEntity = new OrdersEntity();
                ordersEntity.setCustomer_ID(this.getLoggedInUser().getCustomerId());
                ordersEntity.setOrder_Date(new Timestamp(System.currentTimeMillis()));
                ordersEntity.setOrderStatus(OrderStatus.PROCESSED);
                ordersEntity.setQuantity(basketDataCollector.number_of_items);
                ordersEntity.setProduct_Name(basketDataCollector.title);
                this.ordersRepository.save(ordersEntity);
            }
            return "redirect:basket?confirm=1";
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return "basket";
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    private static class BasketDataCollector {
        private int id;
        private int number_of_items;
        private String title;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getNumber_of_items() {
            return number_of_items;
        }

        public void setNumber_of_items(int number_of_items) {
            this.number_of_items = number_of_items;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }

    private CustomerEntity getLoggedInUser() {
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("customer") != null) {
            return (CustomerEntity) session.getAttribute("customer");
        }
        return null;
    }
}