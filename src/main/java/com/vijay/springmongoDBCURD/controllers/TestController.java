package com.vijay.springmongoDBCURD.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @RequestMapping(path = "/test")
    public String test(){
        return "Ready to go";
    }
}