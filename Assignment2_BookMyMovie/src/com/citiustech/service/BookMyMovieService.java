package com.citiustech.service;

import com.citiustech.model.BookMyMovie;

public class BookMyMovieService {
	
	private BookMyMovieService() {}
	
	public static double calculateDiscount(BookMyMovie b1) {
		double discount=0.0;
		if((b1.getMovieId() == 101 || b1.getMovieId() == 102 || b1.getMovieId() == 103) && b1.getNoOfTickets()<5) {
			discount = 0;
		}else if((b1.getMovieId() == 101 || b1.getMovieId() == 103) && (b1.getNoOfTickets()>=5 && b1.getNoOfTickets()<=10)){
			discount = 15D/100;
		}else if((b1.getMovieId() == 101 || b1.getMovieId() == 103) && (b1.getNoOfTickets()>=10 && b1.getNoOfTickets()<=15)){
			discount = 20D/100;
		}else if((b1.getMovieId() == 102) && (b1.getNoOfTickets()>=5 && b1.getNoOfTickets()<10)){
			discount = 10D/100;
		}else if((b1.getMovieId() == 102) && (b1.getNoOfTickets()>=10 && b1.getNoOfTickets()<=15)){
			discount = 15D/100;
		}
		
		return discount;
		
	}
	
	public static double calculateTicketAmount(BookMyMovie b1){
	
		double totalAmount = 0;
		if(b1.getMovieId()==101) {
			totalAmount=(120*(b1.getNoOfTickets()))-(120*b1.getNoOfTickets()*(calculateDiscount(b1)));
		}else if(b1.getMovieId()==102) {
			totalAmount=(170*(b1.getNoOfTickets()))-(170*b1.getNoOfTickets()*calculateDiscount(b1));
		}else if(b1.getMovieId()==103) {
			totalAmount=(150*(b1.getNoOfTickets()))-(150*b1.getNoOfTickets()*calculateDiscount(b1));
		}else {
			System.out.println("Sorry Invalid Movie Id");
		}
		return totalAmount;
		
	}
}
