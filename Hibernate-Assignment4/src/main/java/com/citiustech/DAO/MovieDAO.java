package com.citiustech.DAO;

public interface MovieDAO {

	public void findMaxRevenue(String language);
	public void findMinRevenue(String language);
	public void sumOfRevenue(String language);
	public void averageOfRevenue(String language);
	public void totalNoOfMovies(String language);
	public void getMovieCountForEachLanguage();
}
