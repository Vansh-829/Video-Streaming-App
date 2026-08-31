package com.techcoder.movie_catelog_service.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.techcoder.movie_catelog_service.entity.MovieInfo;

@Service
public interface MovieInfoService {
	
	public List<MovieInfo> saveall(List<MovieInfo> movieInfo);
	
	public List<MovieInfo> viewAll();

	public String getMoviePath(Long id);
}
