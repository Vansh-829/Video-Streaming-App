package com.techcoder.movie_streaming_service.controller;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class MovieCatalogService {
	
	public final String CATELOG_SERVICE ="http://movie-catelog-service";

	private RestTemplate restTemplate;

	public MovieCatalogService(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}
	
	public String getMoviePath(Long movieId) {
		var response = restTemplate.getForEntity(CATELOG_SERVICE + "/movie-info/find-by-id/{movieIndoId}",String.class,movieId);
		return response.getBody();
		
	}
	
}
