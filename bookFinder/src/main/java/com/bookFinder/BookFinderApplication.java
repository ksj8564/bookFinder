package com.bookFinder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.web.client.RestTemplate;

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
