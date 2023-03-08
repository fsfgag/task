package org.example.pojo;


import lombok.Data;

import java.sql.Date;
import java.util.List;

@Data
public class Order {
    private int order_id;
    private Date order_date;
    private List<Product> productList;
}
