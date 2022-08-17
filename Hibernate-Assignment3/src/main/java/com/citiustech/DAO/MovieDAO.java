package com.citiustech.DAO;

import java.util.List;

import com.citiustech.model.Movie;

public interface MovieDAO {

	public List<Movie> getMovieDetails(String language);
	public List<Movie> getMovie(String directorName);
	public List<Movie> addMovies();
	public void updateRevenue(int id);
	public void deleteMovie(String movieName);
	public List<String> getDistinctLanguages();
	public List<Object[]> getMovieNameDirectorName();
	
}
