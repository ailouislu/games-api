package com.nzlouis.utils.config;

import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;


/**
 * @author Louis
 *
 */
@OpenAPIDefinition(
		// OpenAPI definition description
        info = @Info(
                title = "User Service",
                version = "0.1.0",
                description = "A service for searching, creating, retrieving, updating, and deleting users."
        		),
        // Request service address configuration, which can be configured for different environments
        servers = {
        		@Server(
		        		url = "http://localhost:8080",
		        		description = "Local"
		        		)
        }
)
@Configuration
public class OpenApiConfig {
	
	// Group configuration: Users
	@Bean
	public GroupedOpenApi userOpenApi() {
		String[] packagesToscan = {"com.nzlouis.user"};
		return GroupedOpenApi.builder().group("User").packagesToScan(packagesToscan)
				.build();
	}
	// Group configuration: Game
	@Bean
	public GroupedOpenApi gameOpenApi() {
		String[] packagesToscan = {"com.nzlouis.game"};
		return GroupedOpenApi.builder().group("Game").packagesToScan(packagesToscan)
				.build();
	}
	// Group configuration: Platform
	@Bean
	public GroupedOpenApi platformOpenApi() {
		String[] packagesToscan = {"com.nzlouis.platform"};
		return GroupedOpenApi.builder().group("Platform").packagesToScan(packagesToscan)
				.build();
	}
}
