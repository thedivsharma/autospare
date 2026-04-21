package com.autospare.model;

import java.time.LocalDateTime;

public class Invoice {

    private Long invoiceId;
    private String customerName;
    private String itemName;
    private double price;
    private int quantity;
    private double total;
    private LocalDateTime dateTime;

    public Invoice(Long invoiceId, String customerName, String itemName,
                   double price, int quantity, double total,
                   LocalDateTime dateTime) {
        this.invoiceId = invoiceId;
        this.customerName = customerName;
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
        this.total = total;
        this.dateTime = dateTime;
    }

    public Long getInvoiceId() {
        return invoiceId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getItemName() {
        return itemName;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getTotal() {
        return total;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }
}