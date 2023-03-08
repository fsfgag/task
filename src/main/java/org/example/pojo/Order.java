package org.example.pojo;

import lombok.Data;

import java.sql.Date;
import java.util.List;

@Data
public class Order {
    private int no;
    private int orderId;
    private int customerId;
    private int productId;
    private Date date;
    private List<Product> productList;
}
