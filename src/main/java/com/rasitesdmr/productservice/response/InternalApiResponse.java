package com.rasitesdmr.productservice.response;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.List;

@Data
@Builder
public class InternalApiResponse<T> { // Rest Api'miz için tek tipte bir response yapısı oluşturup hertürlü response için bunu kullanabileceğiz.
    private FriendlyMessageResponse friendlyMessageResponse;  // mesajın title ve description kısmı bulunuyor
    private T payload;  // Response vereceğiz.
    private boolean hasError; // Error varmı yokmu.
    private List<String> errorMessage;
    private HttpStatus httpStatus;
}
