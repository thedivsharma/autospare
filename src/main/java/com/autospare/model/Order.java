package com.autospare.model;

import java.util.ArrayList;
import java.util.List;

public class Order {

    private Long orderId;
    private String status;
    private List<OrderItem> items = new ArrayList<>();

    public Order() {
    }

    public Order(Long orderId, String status) {
        this.orderId = orderId;
        this.status = status;
    }

    public void addItem(OrderItem item) {
        items.add(item);
    }

    public double calculateTotal() {
        return items.stream()
                .mapToDouble(OrderItem::getSubtotal)
                .sum();
    }

    public Long getOrderId() {
        return orderId;
    }

    public String getStatus() {
        return status;
    }

    public List<OrderItem> getItems() {
        return items;
    }
}