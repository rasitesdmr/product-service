package com.rasitesdmr.productservice.request;

import lombok.Data;

@Data
public class ProductCreateRequest {
    private String productName;
    private int quantity;
    private double price;
}
