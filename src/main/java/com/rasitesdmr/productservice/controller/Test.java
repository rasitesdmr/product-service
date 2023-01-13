package com.rasitesdmr.productservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class Test {

    @GetMapping("/tst")
    public String test(){
        return "Merhaba";
    }
}
