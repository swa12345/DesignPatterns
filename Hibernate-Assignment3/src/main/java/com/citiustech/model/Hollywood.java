package com.citiustech.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
//@Table(name="hollywood")
public class Hollywood {

	@Id
	private int movieId;
	@Column(name="moviename")
	private String movieName;
	@Column(name="language")
	private String language;
	@Column(name="releasedn")
	private int releasedIn;
	@Column(name="revenueindollars")
	private int revenueInDollars;
	
	public Hollywood() {
		super();
	}
	
	public Hollywood(int movieId, String movieName, String language, int releasedIn, int revenueInDollars) {
		super();
		this.movieId = movieId;
		this.movieName = movieName;
		this.language = language;
		this.releasedIn = releasedIn;
		this.revenueInDollars = revenueInDollars;
	}
	
	public int getMovieId() {
		return movieId;
	}
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public int getReleasedIn() {
		return releasedIn;
	}
	public void setReleasedIn(int releasedIn) {
		this.releasedIn = releasedIn;
	}
	public int getRevenueInDollars() {
		return revenueInDollars;
	}
	public void setRevenueInDollars(int revenueInDollars) {
		this.revenueInDollars = revenueInDollars;
	}
	@Override
	public String toString() {
		return "Hollywood [movieId=" + movieId + ", movieName=" + movieName + ", language=" + language + ", releasedIn="
				+ releasedIn + ", revenueInDollars=" + revenueInDollars + "]";
	}
	
	
}
