package com.bookFinder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@SpringBootApplication
public class BookFinderApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookFinderApplication.class, args);
	}
}
