package com.frauddetection.frauddetectionapi;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Fraud Detection API")
                        .version("1.0")
                        .description("Banking Transaction Fraud Detection System using Machine Learning"));
    }
}
