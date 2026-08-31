package com.techcoder.movie_catelog_service.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.techcoder.movie_catelog_service.entity.MovieInfo;
import com.techcoder.movie_catelog_service.service.MovieInfoService;

@RestController
@RequestMapping("/movie-info")
public class MovieInfoController {

	private MovieInfoService movieInfoService;
	
	public MovieInfoController(MovieInfoService movieInfoService) {
		this.movieInfoService = movieInfoService;
	}

	@PostMapping("/save")
	@ResponseStatus(code = HttpStatus.CREATED)
	public List<MovieInfo> saveData(@RequestBody List<MovieInfo> movieInfos){
		List<MovieInfo> savedMovieInfo = movieInfoService.saveall(movieInfos);
		return savedMovieInfo;
	}
	
	@GetMapping("/lists")
	public List<MovieInfo> getAllMovieInfo(){
		List<MovieInfo> viewMovieInfo = movieInfoService.viewAll();
		return viewMovieInfo;
	}
	
	@GetMapping("/find-by-id/{movieIndoId}")
	public String getMovieInfoById(@PathVariable Long movieIndoId) {
		return movieInfoService.getMoviePath(movieIndoId);
	}
	
}
