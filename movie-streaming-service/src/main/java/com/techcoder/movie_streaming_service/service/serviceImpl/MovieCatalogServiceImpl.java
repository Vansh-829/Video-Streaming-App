package com.techcoder.movie_streaming_service.service.serviceImpl;


import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.techcoder.movie_streaming_service.constants.Constants;
import com.techcoder.movie_streaming_service.controller.MovieStreamController;
import com.techcoder.movie_streaming_service.service.MovieCatalogService;

@Component
public class MovieCatalogServiceImpl implements MovieCatalogService {

	private RestTemplate restTemplate;
	public static final Logger log = Logger.getLogger(MovieCatalogServiceImpl.class.getName());

	public MovieCatalogServiceImpl(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	@Override
	public String getMoviePath(Long movieId) {
		log.log(Level.INFO,"Fetching from catelog service:",movieId);
		var response = restTemplate.getForEntity(Constants.CATELOG_SERVICE_ENDPOINT.getConstant(), String.class,movieId);
		return response.getBody();
	}

}
