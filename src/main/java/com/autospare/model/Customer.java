package com.autospare.model;

public class Customer {

    private Long customerId;
    private String name;
    private String email;

    public Customer() {
    }

    public Customer(Long customerId, String name, String email) {
        this.customerId = customerId;
        this.name = name;
        this.email = email;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}