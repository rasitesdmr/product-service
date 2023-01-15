package com.rasitesdmr.productservice.exception.handler;

import com.rasitesdmr.productservice.exception.enums.FriendlyMessageCodes;
import com.rasitesdmr.productservice.exception.exceptions.ProductNotCreatedException;
import com.rasitesdmr.productservice.exception.utils.FriendlyMessageUtils;
import com.rasitesdmr.productservice.response.FriendlyMessageResponse;
import com.rasitesdmr.productservice.response.InternalApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Collections;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ProductNotCreatedException.class)
    public InternalApiResponse<String> handleProductNotCreatedException(ProductNotCreatedException productNotCreatedException) {
        return InternalApiResponse.<String>builder()
                .friendlyMessageResponse(FriendlyMessageResponse.builder()
                        .title(FriendlyMessageUtils.getFriendlyMessage(productNotCreatedException.getLanguage(), FriendlyMessageCodes.ERROR))
                        .description(FriendlyMessageUtils.getFriendlyMessage(productNotCreatedException.getLanguage(), productNotCreatedException.getFriendlyMessageCode()))
                        .build())
                .httpStatus(HttpStatus.BAD_REQUEST)
                .hasError(true)
                .errorMessage(Collections.singletonList(productNotCreatedException.getMessage()))
                .build();
    }

}
