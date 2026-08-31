package com.techcoder.movie_streaming_service.service;

import java.io.FileNotFoundException;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface MovieStreamingService {
	
	public ResponseEntity<InputStreamResource> getStreamVideo(String videoPath) throws FileNotFoundException;
}
