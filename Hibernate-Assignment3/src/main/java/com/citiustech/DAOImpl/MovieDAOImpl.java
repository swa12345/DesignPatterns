package com.citiustech.DAOImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;

import com.citiustech.DAO.MovieDAO;
import com.citiustech.model.Director;
import com.citiustech.model.Hollywood;
import com.citiustech.model.Movie;
import com.citiustech.util.HibernateUtil;

public class MovieDAOImpl implements MovieDAO {
	
	SessionFactory sf = HibernateUtil.getSessionFactory();
	Session session = sf.openSession();
	
	public List<Movie> getMovieDetails(String language) {
		Query q1 = session.createQuery("from Movie m where m.language=:l");
		q1.setString("l", language);
		List<Movie> list = q1.list();
		for(Movie m : list) {
			System.out.println(m);
		}
		return list;
	}

	public List<Movie> getMovie(String directorName) {
		Query q2 = session.createQuery("from Movie m where m.director.directorName=:n");
		q2.setString("n", directorName);
		List<Movie> list1 = q2.list();
		for(Movie m : list1) {
			System.out.println(m);
		}
		return list1;
	}

	public List<Movie> addMovies() {
		session.beginTransaction();
		String language = "English";
		Query q3 = session.createQuery("from Movie m where m.language=:lang");
		q3.setString("lang", language);
		List<Movie> list2 = q3.list();
		for(Movie m4:list2) {
			Hollywood h = new Hollywood(m4.getMovieId(),m4.getMovieName(),m4.getLanguage(),m4.getReleasedIn(),m4.getRevenueInDollars());
			session.save(h);
			
			System.out.println(h);
		}
		session.getTransaction().commit();
		return list2;
	}

	public void updateRevenue(int id) {
		session.beginTransaction();
		Query q4 = session.createQuery("update Movie m set m.revenueInDollars=m.revenueInDollars+100000 where m.movieId=:mov");
		q4.setParameter("mov",id);
		int status  = q4.executeUpdate();
		System.out.println(status);
		session.getTransaction().commit();
	}

	public void deleteMovie(String movieName) {
		session.beginTransaction();
		Query q5 = session.createQuery("delete from Movie m where m.movieName=:mname");
		q5.setParameter("mname", movieName);	
		q5.executeUpdate();
		session.getTransaction().commit();
		System.out.println("Movie Deleted"+movieName);
	}

	public List<String> getDistinctLanguages() {
		Criteria criteria = session.createCriteria(Movie.class);
		criteria.setProjection(Projections.distinct(Projections.property("language")));
		List<String> languages = criteria.list();
		for(String l:languages) {
			System.out.println("Distinct Languages: "+l);
		}
		return languages;
	}

	public List<Object[]> getMovieNameDirectorName() {
		Query q7 = session.createQuery("select m.movieName, m.director.directorName from Movie m");
		List<Object[]> newList = q7.list();
		for(Object[] l:newList) {
			System.out.println(l[0]+" "+l[1]);
		}
//		System.out.println(newList);
		return newList;
	}
	
	

}
