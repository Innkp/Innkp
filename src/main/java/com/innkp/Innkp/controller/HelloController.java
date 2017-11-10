package com.innkp.Innkp.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/wechat")
public class HelloController {
    
    @RequestMapping("/yangxue")
    public String index() {
        return "Greetings from Spring Boot!";
    }
    
}
