package com.techcoder.movie_catelog_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.techcoder.movie_catelog_service.entity.MovieInfo;

@Repository
public interface MovieInfoRepo extends JpaRepository<MovieInfo, Long> {

}
