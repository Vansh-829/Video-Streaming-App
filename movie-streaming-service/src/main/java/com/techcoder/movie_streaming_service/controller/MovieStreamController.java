package com.techcoder.movie_streaming_service.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("movie-stream")
public class MovieStreamController {

	public static final String DIR_PATH = "D:\\Workspace\\Video_Streaming_App\\Store\\";
	public static final Logger log = Logger.getLogger(MovieStreamController.class.getName());

	private MovieCatalogService movieCatalogService;
	
	public MovieStreamController(MovieCatalogService movieCatalogService) {
		this.movieCatalogService = movieCatalogService;
	}

	@GetMapping("{videoPath}")
	public ResponseEntity<InputStreamResource> streamVideo(@PathVariable String videoPath)
			throws FileNotFoundException {
		File file = new File(DIR_PATH + videoPath);
		if (file.exists()) {
			InputStreamResource inputStreamResource = new InputStreamResource(new FileInputStream(file));
			return ResponseEntity.ok().contentType(MediaType.parseMediaType("video/mp4")).body(inputStreamResource);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@GetMapping("/with-id/{movieInfoId}")
	public ResponseEntity<InputStreamResource> streamVideoWithId(@PathVariable Long movieInfoId)
			throws FileNotFoundException {
	String moviePath = movieCatalogService.getMoviePath(movieInfoId);
	log.log(Level.INFO,"Resolved Movie path = {0}",moviePath);
	return streamVideo(moviePath);
	}
}