package com.rasitesdmr.productservice.controller;

import com.rasitesdmr.productservice.enums.Language;
import com.rasitesdmr.productservice.exception.enums.FriendlyMessageCodes;
import com.rasitesdmr.productservice.exception.utils.FriendlyMessageUtils;
import com.rasitesdmr.productservice.request.ProductCreateRequest;
import com.rasitesdmr.productservice.response.FriendlyMessageResponse;
import com.rasitesdmr.productservice.response.InternalApiResponse;
import com.rasitesdmr.productservice.response.ProductResponse;
import com.rasitesdmr.productservice.service.ProductService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
@Slf4j
public class ProductController {

    private final ProductService productService;


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/{language}/createdProduct")
    public InternalApiResponse<ProductResponse>createProduct(@PathVariable("language")Language language, @RequestBody ProductCreateRequest productCreateRequest){
        log.debug("[{}][createProduct] -> request: {}", this.getClass().getSimpleName(), productCreateRequest);
        ProductResponse productResponse = productService.createProduct(language,productCreateRequest);
        log.debug("[{}][createProduct] -> response: {}", this.getClass().getSimpleName(), productResponse);
        return InternalApiResponse.<ProductResponse>builder()
                .friendlyMessageResponse(FriendlyMessageResponse.builder()
                        .title(FriendlyMessageUtils.getFriendlyMessage(language, FriendlyMessageCodes.SUCCESS))
                        .description(FriendlyMessageUtils.getFriendlyMessage(language,FriendlyMessageCodes.PRODUCT_SUCCESSFULLY_CREATED))
                        .build())
                .httpStatus(HttpStatus.CREATED)
                .hasError(false)
                .payload(productResponse)
                .build();

    }
    @GetMapping("/message")
    public String testMessage(String message){
        return message;
    }

    @GetMapping("/messageee")
    public String testMessageee(String message){
        return message;
    }

}
