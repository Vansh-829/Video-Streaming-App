package com.techcoder.movie_streaming_service.configuration;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestConfiguration {

    @Bean
    @LoadBalanced
    RestTemplate restTemplate() {
		//RestTemplate allows us to make http request to any other resource
		return new RestTemplate();
	}
	
}
