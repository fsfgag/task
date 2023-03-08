package org.example.pojo;

import lombok.Data;

import java.util.List;

@Data
public class Customer {
    private int customer_id;
    private String customer_name;
    private String customer_address;
    private float customer_balance;
    private List<Order> orderList;
}
