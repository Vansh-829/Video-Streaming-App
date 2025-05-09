package com.techcoder.movie_streaming_service.service.serviceImpl;


import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.techcoder.movie_streaming_service.constants.Constants;
import com.techcoder.movie_streaming_service.service.MovieCatalogService;

@Component
public class MovieCatalogServiceImpl implements MovieCatalogService {

	private RestTemplate restTemplate;

	public MovieCatalogServiceImpl(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	@Override
	public String getMoviePath(Long movieId) {
		var response = restTemplate.getForEntity(Constants.CATELOG_SERVICE_ENDPOINT.getConstant(), String.class,movieId);
		return response.getBody();
	}

}
