package com.citiustech.DAO;

import com.citiustech.model.Movie;

public interface MovieDAO {

	public String addMovie(Movie m);
	public void deleteMovie(Movie movie) throws Exception;
	public void updateMovie(Movie movie) throws Exception;
	public Movie getMovieDetails(String movieId);
	
}
