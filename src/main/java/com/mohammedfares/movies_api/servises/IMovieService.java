package com.mohammedfares.movies_api.servises;

import com.mohammedfares.movies_api.models.Movie;
import java.util.List;
public interface IMovieService {
	
	public List<Movie> getAllMovies();
	public Movie insertMovie(Movie movie);

}
