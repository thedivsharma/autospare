package com.autospare.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    private String customerName;
    private String itemName;
    private int quantity;
    private double total;
    private String status;
    private LocalDateTime orderDate;

    public Order() {
    }

    public Order(String customerName, String itemName, int quantity,
                 double total, String status, LocalDateTime orderDate) {
        this.customerName = customerName;
        this.itemName = itemName;
        this.quantity = quantity;
        this.total = total;
        this.status = status;
        this.orderDate = orderDate;
    }

    public Long getOrderId() {
        return orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getItemName() {
        return itemName;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getTotal() {
        return total;
    }

    public String getStatus() {
        return status;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }
}