package com.rasitesdmr.productservice.service;

import com.rasitesdmr.productservice.enums.Language;
import com.rasitesdmr.productservice.request.ProductCreateRequest;
import com.rasitesdmr.productservice.request.ProductUpdateRequest;
import com.rasitesdmr.productservice.response.ProductResponse;

import java.util.List;

public interface ProductService {

    ProductResponse createProduct(Language language , ProductCreateRequest productCreateRequest);

    ProductResponse getProduct(Language language , Long productId);

    List<ProductResponse> getAllProducts(Language language);

    ProductResponse updateProduct(Language language, Long productId, ProductUpdateRequest productUpdateRequest);

    ProductResponse deleteProduct(Language language , Long productId);
}
