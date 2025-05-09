package com.techcoder.movie_streaming_service.service.serviceImpl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.techcoder.movie_streaming_service.service.MovieStreamingService;

@Component
public class MovieStreamingServiceImpl implements MovieStreamingService {

	@Value("${store.dir.path}")
	private String DIR_PATH;

	@Override
	public ResponseEntity<InputStreamResource> getStreamVideo(String videoPath) throws FileNotFoundException {
		File file = new File(DIR_PATH + videoPath);
		if (file.exists()) {
			InputStreamResource inputStreamResource = new InputStreamResource(new FileInputStream(file));
			return ResponseEntity.ok()
					.contentType(MediaType.parseMediaType("video/mp4"))
					.body(inputStreamResource);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

}
