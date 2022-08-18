package com.citiustech.DAOImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.citiustech.DAO.MovieDAO;
import com.citiustech.model.Movie;
import com.citiustech.util.HibernateUtil;

public class MovieDAOImpl implements MovieDAO {
	
	SessionFactory sf = HibernateUtil.getSessionFactory();
	Session session = sf.openSession();

	public void findMaxRevenue(String language) {
		Query maxRevenueq = session.createQuery("select max(revenueInDollars) from Movie where language=:l");
		maxRevenueq.setString("l", language);
		List<Integer> maxRevenueList = maxRevenueq.list();
		System.out.println("Max Revenue of Movie in " + language +" language is "+ maxRevenueList.get(0));
		
	}

	public void findMinRevenue(String language) {
		Query minRevenueq = session.createQuery("select min(revenueInDollars) from Movie where language=:l");
		minRevenueq.setString("l", language);
		List<Integer> minRevenueList = minRevenueq.list();
		System.out.println("Min Revenue of Movie in " + language +" language is "+ minRevenueList.get(0));
		
	}

	public void sumOfRevenue(String language) {
		Query sumRevenueq = session.createQuery("select sum(revenueInDollars) from Movie where language=:l");
		sumRevenueq.setString("l", language);
		List<Integer> sumRevenueList = sumRevenueq.list();
		System.out.println("Sum of Revenue of All Movies in " + language +" language is "+ sumRevenueList.get(0));
		
	}

	public void averageOfRevenue(String language) { 
		Query averageRevenueq = session.createQuery("select avg(revenueInDollars) from Movie where language=:l");
		averageRevenueq.setString("l", language);
		List<Integer> averageRevenueList = averageRevenueq.list();
		System.out.println("Average of Revenue of All Movies in " + language +" language is "+ averageRevenueList.get(0));
		
	}

	public void totalNoOfMovies(String language) {
		Query totalNoOfMoviesq = session.createQuery("select count(movieId) from Movie where language=:l");
		totalNoOfMoviesq.setString("l", language);
		List<Integer> totalNoOfMoviesList = totalNoOfMoviesq.list();
		System.out.println("Total no of Movies in " + language +" language is "+ totalNoOfMoviesList.get(0));
		
	}

	public void getMovieCountForEachLanguage() {
		Query listOfMovies = session.createQuery("select language,count(movieId) from Movie group by language having count(movieId)>=2 order by count(movieId) desc");
		List<Object[]> movieList = listOfMovies.list();
		for(Object[] obj : movieList) {
			System.out.println(obj[0]+" "+obj[1]);
		}
		
	}

}
