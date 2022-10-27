package com.gcoce.cloudapp.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@OpenAPIDefinition(info = @Info(title = "Flights API", version = "1.1", description = "Flights Information"))
public class SwaggerConfig {
}
