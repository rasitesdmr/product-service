package com.rasitesdmr.productservice.mapper;

import com.rasitesdmr.productservice.model.Product;
import com.rasitesdmr.productservice.request.ProductCreateRequest;
import com.rasitesdmr.productservice.request.ProductUpdateRequest;
import com.rasitesdmr.productservice.response.ProductResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface ProductMapper {

    ProductResponse productToProductResponse(Product product);

    Product productCreateRequestToProduct(ProductCreateRequest productCreateRequest);

    Product productUpdateRequestToProduct(ProductUpdateRequest productUpdateRequest);

    List<ProductResponse> productListToProductResponses(List<Product> productList);


}
