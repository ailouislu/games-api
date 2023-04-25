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
                title = "Games API",
                version = "0.1.0",
                description = "A service for searching, creating, retrieving, updating, and deleting games."
        		),
        // Request service address configuration, which can be configured for different environments
        servers = {
        		@Server(
		        		url = "/",
		        		description = "Games Api Server URL"
		        		)
        }
)
@Configuration
public class OpenApiConfig {

	// Group configuration: Game
	@Bean
	public GroupedOpenApi gameOpenApi() {
		String[] packagesToscan = {"com.nzlouis.game"};
		return GroupedOpenApi.builder().group("Games")
				.packagesToScan(packagesToscan)
				.pathsToExclude("/api/genres/**", "/genres/**")
				.pathsToMatch("/api/games/**", "/games/**")
				.build();
	}
	// Group configuration: Genres
	@Bean
	public GroupedOpenApi genresOpenApi() {
		String[] packagesToscan = {"com.nzlouis.game"};
		return GroupedOpenApi.builder().group("Genres")
				.packagesToScan(packagesToscan)
				.pathsToExclude("/api/games/**", "/games/**")
				.pathsToMatch("/api/genres/**", "/genres/**")
				.build();
	}
	// Group configuration: Platform
	@Bean
	public GroupedOpenApi platformOpenApi() {
		String[] packagesToscan = {"com.nzlouis.platform"};
		return GroupedOpenApi.builder().group("Platforms")
				.packagesToScan(packagesToscan)
				.pathsToExclude("/api/platformGames/**", "/platformGames/**")
				.pathsToMatch("/api/platforms/**", "/platforms/**")
				.build();
	}
	// Group configuration: PlatformGames
	@Bean
	public GroupedOpenApi platformGamesOpenApi() {
		String[] packagesToscan = {"com.nzlouis.platform"};
		return GroupedOpenApi.builder().group("PlatformGames")
				.packagesToScan(packagesToscan)
				.pathsToExclude("/api/platforms/**", "/platformGames/**")
				.pathsToMatch("/api/platformGames/**", "/platformGames/**")
				.build();
	}
	// Group configuration: Users
	@Bean
	public GroupedOpenApi userOpenApi() {
		String[] packagesToscan = {"com.nzlouis.user"};
		return GroupedOpenApi.builder().group("Users").packagesToScan(packagesToscan)
				.build();
	}

}
