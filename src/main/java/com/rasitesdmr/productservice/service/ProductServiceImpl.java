package com.rasitesdmr.productservice.service;

import com.rasitesdmr.productservice.enums.Language;
import com.rasitesdmr.productservice.exception.enums.FriendlyMessageCodes;
import com.rasitesdmr.productservice.exception.exceptions.ProductNotCreatedException;
import com.rasitesdmr.productservice.mapper.ProductMapper;
import com.rasitesdmr.productservice.model.Product;
import com.rasitesdmr.productservice.repository.ProductRepository;
import com.rasitesdmr.productservice.request.ProductCreateRequest;
import com.rasitesdmr.productservice.request.ProductUpdateRequest;
import com.rasitesdmr.productservice.response.ProductResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Override
    public ProductResponse createProduct(Language language, ProductCreateRequest productCreateRequest) {

        log.debug("[{}][createProduct] -> request: {}", this.getClass().getSimpleName(), productCreateRequest);
        try {
            Product product = productMapper.productCreateRequestToProduct(productCreateRequest);
            product = productRepository.save(product);
            log.debug("[{}][createProduct] -> response: {}", this.getClass().getSimpleName(), product);
            return productMapper.productToProductResponse(product);
        } catch (Exception exception) {
            throw new ProductNotCreatedException(language, FriendlyMessageCodes.PRODUCT_NOT_CREATED_EXCEPTION, "product request:" + productCreateRequest.toString());
        }
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
