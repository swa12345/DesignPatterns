package com.citiustech.model;

public class BookMyMovie {

	private int movieId;
	private int noOfTickets;
	private double discount;
	private double totalAmount;
	
	public BookMyMovie() {
		super();
	}
	
	public BookMyMovie(int movieId, int noOfTickets) {
		super();
		this.movieId = movieId;
		this.noOfTickets = noOfTickets;
	}
	public int getMovieId() {
		return movieId;
	}
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
	public int getNoOfTickets() {
		return noOfTickets;
	}
	public void setNoOfTickets(int noOfTickets) {
		this.noOfTickets = noOfTickets;
	}
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	
	
}
