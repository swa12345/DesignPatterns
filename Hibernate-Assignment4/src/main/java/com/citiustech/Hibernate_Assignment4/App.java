package com.citiustech.Hibernate_Assignment4;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.citiustech.DAOImpl.MovieDAOImpl;
import com.citiustech.model.Director;
import com.citiustech.model.Movie;
import com.citiustech.util.HibernateUtil;

public class App 
{
	public static MovieDAOImpl daoImpl = new MovieDAOImpl();
    public static void main( String[] args )
    {
    	daoImpl.findMaxRevenue("English");
    	daoImpl.findMinRevenue("English");
    	daoImpl.sumOfRevenue("Hindi");
    	daoImpl.averageOfRevenue("Hindi");
    	daoImpl.totalNoOfMovies("Hindi");
    	daoImpl.getMovieCountForEachLanguage();
    	
//      SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
//      Session session = sessionFactory.openSession();
//      Director d = new Director(104,"R. Balki",1969);
//      Movie m = new Movie(1005,"Paa","Hindi",2009,4700000,d);
//      session.beginTransaction();
//      session.save(m);
//      session.getTransaction().commit();
    }
}
