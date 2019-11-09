/**
 * Created as part of Sabre hackathon 2019.
 */
package com.sabrepay.sabreapp.swagger;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 
 * SwaggerConfig.java Created On: Oct 26, 2019 Created By: M1041768
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2).select()
            .apis(RequestHandlerSelectors.basePackage("com.sabrepay.sabreapp")).paths(PathSelectors.any())
            .build().apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfo("Sabre Pay App", "Sabre Pay App for Sabre hackathon 2019", "1.0", "Terms of service",
            new Contact("Navneet Thakur", "www.mindtree.com", "navneet.thakur@mindtree.com"),
            "Licensed to Mindtree Ltd", "<API License Here>", Collections.emptyList());
    }
}
