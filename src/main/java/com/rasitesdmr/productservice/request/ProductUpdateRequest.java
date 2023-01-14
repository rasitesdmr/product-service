package com.rasitesdmr.productservice.request;

import lombok.Data;

@Data
public class ProductUpdateRequest {
    private Long productId;
    private String productName;
    private int quantity;
    private double price;
}
