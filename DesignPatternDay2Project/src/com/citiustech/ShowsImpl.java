package com.citiustech;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ShowsImpl implements Shows
{	
//	String fname="";
//	ShowManagerImpl smpl = new ShowManagerImpl();
	@Override
	public void displayAllShows(List<Show> shows) {

		shows.forEach(System.out::println);
		
	}

}

