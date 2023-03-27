package com.cs2tp.notsketchers.controller;


import com.cs2tp.notsketchers.entities.*;
import com.cs2tp.notsketchers.repository.OrdersRepository;
import com.cs2tp.notsketchers.repository.ProductRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class AdminController {
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private OrdersRepository ordersRepository;

    @GetMapping("/admin")
    public String returnAdmin(Model model) {
        if (this.isUserAdmin()) {
            CustomerEntity customer = this.getLoggedInUser();
            model.addAttribute("loggedInUser", customer);
            List<ProductEntity> productEntities = this.getProductsOnSupply(StockSupply.LOW_STOCK, StockSupply.OUT_OF_STOCK);
            model.addAttribute("lowStockProducts", productEntities);
            model.addAttribute("lowStockProducts", productEntities);
            model.addAttribute("lowStockProducts", productEntities);
            return "admin";
        }
        return "home";
    }

    @GetMapping("/admin/sales")
    public String returnAdminSales(Model model) {
        if (this.isUserAdmin()) {
            List<OrdersEntity> orders = ordersRepository.findAll();
            model.addAttribute("orders", orders);
            return "admin/sales";
        }
        return "home";
    }

    @GetMapping("/admin/products")
    public String returnAdminStock(Model model) {
        if (this.isUserAdmin()) {
            List<ProductEntity> products = productRepository.findAll();
            model.addAttribute("products", products);
            return "admin/products";
        }
        return "home";
    }

    @GetMapping("/admin/add")
    public String returnAdminAdd() {
        if (this.isUserAdmin()) {
            return "admin/add";
        }
        return "home";
    }

    @PostMapping("/admin/add")
    public String addProduct(@RequestParam("productName") String productName,
                             @RequestParam("productCategory") String productCategory,
                             @RequestParam("productPrice") String productPrice,
                             @RequestParam("productStockCount") int productStockCount,
                             @RequestParam("productImageFilePath") String productImageFilePath,
                             @RequestParam("gender") String gender,
                             @RequestParam("shoeSize") String shoeSize
    ) {
        ProductEntity product = new ProductEntity();
        product.setProductName(productName);
        product.setProductCategory(productCategory);
        product.setProductPrice(new BigDecimal(productPrice));
        product.setProductStockCount(productStockCount);
        product.setProductImageFilePath(productImageFilePath);
        product.setGender(gender);
        product.setShoeSize(shoeSize);
        this.productRepository.save(product);
        return "redirect:/admin/add?success=1";
    }

    @PostMapping("/admin/product/update")
    public String updateProduct(@RequestParam("productId") int productId,
                                @RequestParam("productName") String productName,
                                @RequestParam("stockCount") int stockCount
    ) {
        ProductEntity product = this.productRepository.findById(productId).get();
        product.setProductName(productName);
        product.setProductStockCount(stockCount);
        this.productRepository.save(product);
        return "redirect:/admin/products";
    }

    @PostMapping("/admin/order/update")
    public String updateOrder(@RequestParam("orderId") int orderId,
                              @RequestParam("orderStatus") String orderStatus
    ) {
        OrderStatus newStatus = Enum.valueOf(OrderStatus.class, orderStatus);
        OrdersEntity order = this.ordersRepository.findById(orderId).get();
        order.setOrderStatus(newStatus);
        this.ordersRepository.save(order);

        return "redirect:/admin/sales";
    }


    private boolean isUserAdmin() {
        CustomerEntity customer = this.getLoggedInUser();
        if (customer != null) {
            return customer.isCustomerIsAdmin();
        }
        return false;
    }

    private CustomerEntity getLoggedInUser() {
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("customer") != null) {
            return (CustomerEntity) session.getAttribute("customer");
        }
        return null;
    }

    private List<ProductEntity> getProductsOnSupply(StockSupply... stockSupplies) {
        List<ProductEntity> products = this.productRepository.findAll();
        List<ProductEntity> res = new ArrayList<>();
        for (ProductEntity product : products) {
            if (Arrays.stream(stockSupplies).toList().contains(product.getSupply())) {
                res.add(product);
            }
        }
        return res;
    }
}
