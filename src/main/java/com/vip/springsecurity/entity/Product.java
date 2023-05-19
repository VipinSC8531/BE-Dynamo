package com.vip.springsecurity.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Product {
    int productId;
    String name;
    int quantity;
    Double price;
}
