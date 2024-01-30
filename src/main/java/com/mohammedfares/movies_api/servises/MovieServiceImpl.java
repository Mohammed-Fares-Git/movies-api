package com.mohammedfares.movies_api.servises;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mohammedfares.movies_api.models.Movie;
@Service
public class MovieServiceImpl implements IMovieService {
	
	private final MovieRepository movieRepository;
	
	public MovieServiceImpl(MovieRepository movieRepository) {
		this.movieRepository = movieRepository;
	}

	@Override
	public List<Movie> getAllMovies() {
		return movieRepository.findAll();
	}

	@Override
	public Movie insertMovie(Movie movie) {
		return movieRepository.save(movie);
	}

}
