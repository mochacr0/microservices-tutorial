package com.example.commonservice.controllers;

import com.example.commonservice.configs.CommonConfiguration;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CommonController {
    private final CommonConfiguration configuration;
    @GetMapping("/common/status")
    public String getStatus() {
        return "Common route OK";
    }

    @GetMapping("/common/config")
    public String getConfig() {
        return String.format("Config: %s", configuration.getKey());
    }
}
