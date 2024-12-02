package com.geyao.comspringboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GeyaoController {
    @GetMapping("/geyao")
    public String getName(){
        return "geyao is cool";
    }
}
