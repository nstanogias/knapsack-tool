package com.nstanogias.knapsack.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.nstanogias.knapsack.controller"))
                .paths(regex("/knapsack.*"))
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "My Knapsack Optimizer Service API",
                "Knapsack Rest Service Endpoints.",
                "API TOS",
                "Terms of service",
                new Contact("Nikolaos Stanogias", "https://nstanogias.github.io/", "nstanogias@gmail.com"),
                "License of API", "API license URL", Collections.emptyList());
    }
}