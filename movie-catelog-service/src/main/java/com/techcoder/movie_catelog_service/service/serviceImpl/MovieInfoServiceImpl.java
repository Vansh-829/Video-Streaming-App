package com.techcoder.movie_catelog_service.service.serviceImpl;

import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.stereotype.Component;

import com.techcoder.movie_catelog_service.entity.MovieInfo;
import com.techcoder.movie_catelog_service.repository.MovieInfoRepo;
import com.techcoder.movie_catelog_service.service.MovieInfoService;

@Component
public class MovieInfoServiceImpl implements MovieInfoService {
	
	private MovieInfoRepo movieInfoRepo;
	public static final Logger log = Logger.getLogger(MovieInfoServiceImpl.class.getName());

	public MovieInfoServiceImpl(MovieInfoRepo movieInfoRepo) {
		this.movieInfoRepo = movieInfoRepo;
	}

	@Override
	public List<MovieInfo> saveall(List<MovieInfo> movieInfo) {
		log.log(Level.INFO,"Saving all movies");
		return movieInfoRepo.saveAll(movieInfo) ;
	}

	@Override
	public List<MovieInfo> viewAll() {
		log.log(Level.INFO,"Viewing all movies");
		return movieInfoRepo.findAll();
	}

	@Override
	public String getMoviePath(Long id) {
		log.log(Level.INFO,"Find movie by id");
		Optional<MovieInfo>movieOptional =movieInfoRepo.findById(id);
		return movieOptional.map(MovieInfo::getPath).orElse(null) ;
	}

}
