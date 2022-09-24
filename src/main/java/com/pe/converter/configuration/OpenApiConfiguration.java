package com.pe.converter.configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfiguration {

	 @Bean(name = "MoneyExchangeAppApi")
	    public OpenAPI bloggingOpenApi() {
	        return new OpenAPI()
	                .components(new Components())
	                .info(new Info()
	                        .title("Money Exchange Application API")
	                        .description("Money Exchange API implemented with Spring Boot RESTful service by Hans Retes"));
	    }
}
