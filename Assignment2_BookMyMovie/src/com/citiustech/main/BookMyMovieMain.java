package com.citiustech.main;

import java.util.Scanner;

import com.citiustech.model.BookMyMovie;
import com.citiustech.service.BookMyMovieService;


public class BookMyMovieMain {
	
	public static void main(String[] args) {
		BookMyMovie b2 = new BookMyMovie();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the details");
		System.out.println("Enter Movie Id");
		b2.setMovieId(sc.nextInt());
		System.out.println("Enter No of Tickets");
		b2.setNoOfTickets(sc.nextInt());
		System.out.println(BookMyMovieService.calculateTicketAmount(b2));
		

	}

}
