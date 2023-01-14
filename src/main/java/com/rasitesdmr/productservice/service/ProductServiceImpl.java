package com.rasitesdmr.productservice.service;

import com.rasitesdmr.productservice.enums.Language;
import com.rasitesdmr.productservice.request.ProductCreateRequest;
import com.rasitesdmr.productservice.request.ProductUpdateRequest;
import com.rasitesdmr.productservice.response.ProductResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    @Override
    public ProductResponse createProduct(Language language, ProductCreateRequest productCreateRequest) {
        return null;
    }

    @Override
    public ProductResponse getProduct(Language language, Long productId) {
        return null;
    }

    @Override
    public List<ProductResponse> getAllProducts(Language language) {
        return null;
    }

    @Override
    public ProductResponse updateProduct(Language language, Long productId, ProductUpdateRequest productUpdateRequest) {
        return null;
    }

    @Override
    public ProductResponse deleteProduct(Language language, Long productId) {
        return null;
    }
}
