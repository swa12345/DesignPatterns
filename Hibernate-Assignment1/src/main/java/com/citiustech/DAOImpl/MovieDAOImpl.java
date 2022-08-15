package com.citiustech.DAOImpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.citiustech.DAO.MovieDAO;
import com.citiustech.model.Movie;
import com.citiustech.util.HibernateUtil;

public class MovieDAOImpl implements MovieDAO{
	
	public SessionFactory sf=HibernateUtil.getSessionFactory();
	public Session session = sf.openSession();

	public String addMovie(Movie m) {
		session.beginTransaction();
		session.save(m);
		session.getTransaction().commit();
		return m.getMovieId();
	}

	public void deleteMovie(Movie movie) throws Exception{
		session.beginTransaction();
		session.delete(movie);
		session.getTransaction().commit();
		
	}

	public void updateMovie(Movie movie) throws Exception{
		session.beginTransaction();
		session.update(movie);
		session.getTransaction().commit();
	}

	public Movie getMovieDetails(String movieId) {
		Movie m = (Movie) session.load(Movie.class, movieId);
		return m;
	}

	
}
