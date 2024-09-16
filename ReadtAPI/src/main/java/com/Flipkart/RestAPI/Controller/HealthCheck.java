package com.Flipkart.RestAPI.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheck {
    @GetMapping("/Healthcheck")
    public String Healthcheck(){
        return "ok";
    }
}
