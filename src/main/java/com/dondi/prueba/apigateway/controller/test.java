package com.dondi.prueba.apigateway.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class test {

    @GetMapping("/apigateway")
    public String getTest() {
        return "Api Gateway Inicializado!!";
    }

}
