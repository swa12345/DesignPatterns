package com.citiustech.Hibernate_Assignment1;

import com.citiustech.DAOImpl.MovieDAOImpl;
import com.citiustech.model.Movie;

public class App 
{
    static MovieDAOImpl mpl = new MovieDAOImpl();
    
    public static void update() {
    	try {
    	Movie m1 = mpl.getMovieDetails("2345");
    	m1.setRevenueInDollars(m1.getRevenueInDollars()+1000000);
        mpl.updateMovie(m1);
    	}catch(Exception e) {
    		System.out.println(e.getMessage());
    	}
      }
    
    public static void get() {
    	Movie m1 = mpl.getMovieDetails("p101");
    	System.out.println(m1);
      }
    
    public static void add() {
    	Movie movie = new Movie("2345","KGF 2","Kanadda",2022,43000000);
    	mpl.addMovie(movie);
      }
    
    public static void delete() {
    	try {
    	Movie m2 = mpl.getMovieDetails("2345");
    	mpl.deleteMovie(m2);
    	}catch(Exception e) {
    		System.out.println(e.getMessage());
    	}
      }
    
    
    public static void main( String[] args )
    {
//        App.add();
//        App.update();
          App.get();
//    	  App.delete();
        
    }
}
