package com.gcoce.cloudapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.net.UnknownHostException;
import java.util.logging.Logger;

@SpringBootApplication
@EnableJpaAuditing
public class CloudAppApplication {

	public static void main(String[] args) throws UnknownHostException {

		SpringApplication.run(CloudAppApplication.class, args);
		Logger logger = Logger.getLogger(CloudAppApplication.class.getName());
		logger.info("Application started");
		String ip = java.net.InetAddress.getLocalHost().getHostAddress();
		logger.info("Application running at --> " + ip);
	}
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins("*").allowedMethods("GET", "POST", "PUT", "DELETE").allowedHeaders("*");
			}
		};
	}

}
