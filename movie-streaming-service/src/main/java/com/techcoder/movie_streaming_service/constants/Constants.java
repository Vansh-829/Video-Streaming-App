package com.techcoder.movie_streaming_service.constants;

public enum Constants {

	CATELOG_SERVICE_ENDPOINT("http://movie-catelog-service/movie-info/find-by-id/{movieIndoId}");

	private final String constant;
	
	public String getConstant() {
		return constant;
	}

	Constants(String constant) {
		this.constant=constant;
	}	
	
}
