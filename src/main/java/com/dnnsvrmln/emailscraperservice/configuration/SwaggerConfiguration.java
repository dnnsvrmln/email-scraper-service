package com.dnnsvrmln.emailscraperservice.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
public class SwaggerConfiguration {

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI().info(new Info().title("Email Scraper Service API")
                .description("Email Scraper Service API to show swagger")
                .version("0.0.1")
                .contact(new Contact().name("dnnsvrmln"))
                .license(new License().name("License of API")
                        .url("API license URL")));
    }

}
