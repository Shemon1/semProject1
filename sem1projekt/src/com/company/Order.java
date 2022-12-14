package com.company;

import java.time.LocalDateTime;

public class Order {
    public Order(Product product, int customerId, LocalDateTime date) {
        this.product = product;
        this.customerId = customerId;
        this.date = date;
    }

    public Product product;
    public int customerId;
    public LocalDateTime date;
}
