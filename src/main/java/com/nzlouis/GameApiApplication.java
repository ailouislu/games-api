package com.nzlouis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;

@Controller
@SpringBootApplication
public class GameApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(GameApiApplication.class, args);
	}

}
