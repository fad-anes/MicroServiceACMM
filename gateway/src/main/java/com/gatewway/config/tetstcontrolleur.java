package com.gatewway.config;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class tetstcontrolleur {

    @GetMapping("/hello")
    public String hello(){
    return "hello";
    }
}
