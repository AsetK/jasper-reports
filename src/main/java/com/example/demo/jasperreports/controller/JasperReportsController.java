package com.example.demo.jasperreports.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JasperReportsController {

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }
}
