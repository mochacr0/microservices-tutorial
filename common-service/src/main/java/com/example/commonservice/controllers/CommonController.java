package com.example.commonservice.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommonController {
    @GetMapping("/common/status")
    public String getStatus() {
        return "Common route OK";
    }
}
