package com.mohammedfares.movies_api.servises;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mohammedfares.movies_api.models.Movie;
@Repository
public interface MovieRepository extends JpaRepository<Movie,Long> {

}
