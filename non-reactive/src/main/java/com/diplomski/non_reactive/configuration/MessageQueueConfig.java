package com.diplomski.non_reactive.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class MessageQueueConfig {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
