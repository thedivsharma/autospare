package com.autospare.model;

public class OrderItem {

    private String itemName;
    private int quantity;
    private double price;

    public OrderItem() {
    }

    public OrderItem(String itemName, int quantity, double price) {
        this.itemName = itemName;
        this.quantity = quantity;
        this.price = price;
    }

    public double getSubtotal() {
        return quantity * price;
    }

    public String getItemName() {
        return itemName;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }
}