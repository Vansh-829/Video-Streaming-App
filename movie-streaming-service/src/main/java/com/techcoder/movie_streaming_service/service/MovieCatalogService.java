package com.techcoder.movie_streaming_service.service;

import org.springframework.stereotype.Service;

@Service
public interface MovieCatalogService {
	
	public String getMoviePath(Long movieId);

}
