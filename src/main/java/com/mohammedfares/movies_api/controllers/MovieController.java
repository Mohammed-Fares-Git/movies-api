package com.mohammedfares.movies_api.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mohammedfares.movies_api.models.Movie;
import com.mohammedfares.movies_api.servises.MovieServiceImpl;
@CrossOrigin(origins = "http://127.0.0.1:5500")
@RestController
@RequestMapping("/movies")
public class MovieController {
	
	private final MovieServiceImpl movieServiceImpl;
	public MovieController(MovieServiceImpl movieServiceImpl) {
		this.movieServiceImpl = movieServiceImpl;
	}
	@GetMapping("/all")
	public ResponseEntity<List<Movie>> getAllMovies(){
		return ResponseEntity.ok(movieServiceImpl.getAllMovies());
	}

}
