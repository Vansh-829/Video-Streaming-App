package com.techcoder.movie_streaming_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MovieStreamingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieStreamingServiceApplication.class, args);
		System.out.println("Running on port 8091");
	}

}
