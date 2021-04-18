package com.bitnet.bitnetgamingnetwork.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class homeController {

    @RequestMapping("/")
    public String home(){
        return "Hello World!";
    }
    @RequestMapping("/hello")
    public String helloWorld(){
        return "Test Request";
    }
}