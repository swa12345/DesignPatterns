package com.citiustech.Hibernate_Assignment3;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.citiustech.DAOImpl.MovieDAOImpl;
import com.citiustech.model.Director;
import com.citiustech.model.Movie;
import com.citiustech.util.HibernateUtil;

public class App 
{
	public static MovieDAOImpl mpl = new MovieDAOImpl();
    public static void main( String[] args )
    {
//        mpl.getMovieDetails("English");
    	  mpl.getMovie("Chris Columbus");
//    	  mpl.addMovies();
//    	mpl.updateRevenue(1005);
//    	mpl.deleteMovie("Baby's Day Out");
//    	mpl.getDistinctLanguages();
//    	mpl.getMovieNameDirectorName();
        
//        SessionFactory sf = HibernateUtil.getSessionFactory();
//        Session session = sf.openSession();
//        Director d = new Director(104,"R. Balki",1972);
//        Movie m = new Movie(1005,"Paa","Hindi",2009,4700000,d);
//        session.beginTransaction();
//        session.save(m);
//        session.getTransaction().commit();
        
    }
}
