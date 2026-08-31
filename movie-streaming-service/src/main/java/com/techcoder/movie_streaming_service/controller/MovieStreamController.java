package com.techcoder.movie_streaming_service.controller;

import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techcoder.movie_streaming_service.service.MovieCatalogService;
import com.techcoder.movie_streaming_service.service.MovieStreamingService;

@RestController
@RequestMapping("movie-stream")
public class MovieStreamController {
	
	public static final Logger log = Logger.getLogger(MovieStreamController.class.getName());

	private MovieStreamingService movieStreamingService;
	private MovieCatalogService movieCatalogService;
	

	public MovieStreamController(MovieStreamingService movieStreamingService, MovieCatalogService movieCatalogService) {
		this.movieStreamingService = movieStreamingService;
		this.movieCatalogService = movieCatalogService;
	}

	@GetMapping("{videoPath}")
	public ResponseEntity<InputStreamResource> streamVideo(@PathVariable String videoPath) throws FileNotFoundException {
		log.log(Level.INFO,"Video path = {0}",videoPath);
		return movieStreamingService.getStreamVideo(videoPath) ;
	}
	
	@GetMapping("/with-id/{movieInfoId}")
	public ResponseEntity<InputStreamResource> streamVideoWithId(@PathVariable Long movieInfoId)
			throws FileNotFoundException {
	String moviePath = movieCatalogService.getMoviePath(movieInfoId);
	log.log(Level.INFO,"Resolved Movie path = {0}",moviePath);
	return streamVideo(moviePath);
	}
}