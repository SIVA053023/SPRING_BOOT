package com.example.Project1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Second {
    @GetMapping("Second")
    public String something(@RequestParam(defaultValue = "0") int num){
        return "Recieved number"+num;
    }
}
