package com.example.firstSpringDemo.controler;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hicontroler {

    @GetMapping(value = "hello")
    public String hellostudent(){
        return "Hello Student";
    }

}
