package com.example.Project1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class One {
    @GetMapping ("one")


 public int getNumber (){
        return 7894;
    }
}
