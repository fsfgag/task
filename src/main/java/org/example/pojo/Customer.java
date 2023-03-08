package org.example.pojo;

import lombok.Data;

import java.util.List;

@Data
public class Customer {
    private int id;
    private String name;
    private String address;
    private float balance;
    private List<Order> orderList;
}
