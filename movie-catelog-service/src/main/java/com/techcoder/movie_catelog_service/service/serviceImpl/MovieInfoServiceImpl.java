package com.techcoder.movie_catelog_service.service.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.techcoder.movie_catelog_service.entity.MovieInfo;
import com.techcoder.movie_catelog_service.repository.MovieInfoRepo;
import com.techcoder.movie_catelog_service.service.MovieInfoService;

@Component
public class MovieInfoServiceImpl implements MovieInfoService {
	
	private MovieInfoRepo movieInfoRepo;

	public MovieInfoServiceImpl(MovieInfoRepo movieInfoRepo) {
		this.movieInfoRepo = movieInfoRepo;
	}

	@Override
	public List<MovieInfo> saveall(List<MovieInfo> movieInfo) {
		
		return movieInfoRepo.saveAll(movieInfo) ;
	}

	@Override
	public List<MovieInfo> viewAll() {
		
		return movieInfoRepo.findAll();
	}

	@Override
	public String getMoviePath(Long id) {
		Optional<MovieInfo>movieOptional =movieInfoRepo.findById(id);
		return movieOptional.map(MovieInfo::getPath).orElse(null) ;
	}

}
