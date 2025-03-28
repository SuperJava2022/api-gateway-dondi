package com.control.apigateway.master.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class ApiControllerMaster {

    @GetMapping("/api-gateway")
    public String apiGateWay() {
        return "Working Api gateway...";
    }

}
