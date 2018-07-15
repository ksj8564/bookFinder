package com.bookFinder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.web.client.RestTemplate;
import org.thymeleaf.extras.springsecurity4.dialect.SpringSecurityDialect;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.dialect.SpringStandardDialect;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;

import com.bookFinder.config.HttpClientConfig;
import com.bookFinder.config.RestTemplateConfig;

@ContextConfiguration(classes = { RestTemplateConfig.class, HttpClientConfig.class })
@SpringBootApplication
public class BookFinderApplication {

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(BookFinderApplication.class, args);
	}
}
