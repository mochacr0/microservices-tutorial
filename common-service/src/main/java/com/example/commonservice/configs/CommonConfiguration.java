package com.example.commonservice.configs;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties
@NoArgsConstructor
@Getter
@Setter
public class CommonConfiguration {
    private String key;
}
