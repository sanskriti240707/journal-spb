package com.example.jrl1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class health {
    @GetMapping("/")
    public String healthcheak(){
        return "Hello Babyyyy";
    }
}
