package com.techcoder.movie_catelog_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MovieCatelogServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieCatelogServiceApplication.class, args);
		System.out.println("Running on 8090.");
	}

}
