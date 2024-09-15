package com.example.Project1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class myclass {

     @GetMapping("abc")
    public String name (){
        return "Say hello";
    }
}
