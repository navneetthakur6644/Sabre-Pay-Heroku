/**
 * Created as part of Sabre hackathon 2019.
 */
package com.sabrepay.sabreapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * 
 * SabreAppApplication.java Created On: Oct 26, 2019 Created By: M1041768
 */
@SpringBootApplication
public class SabreAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(SabreAppApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

}
