package com.citiustech;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.citiustech.exceptions.InvalidShowTimeException;
import com.citiustech.exceptions.SeatsNotAvailableException;
import com.citiustech.exceptions.UnknownShowException;

public class MainClass {

	public static void main(String[] args) throws IOException{

		List<Show> list=new ArrayList<Show>();
			
			ShowManagerImpl dmi=new ShowManagerImpl();
			list=dmi.populate("C:\\Users\\SwapnilK7\\Downloads\\booking.txt");
			System.out.println("SHOWS ARE AS FOLLOWS::");

			list.stream().map(i->i.getShowName()+" "+i.getShowTime()+" "+i.getSeatsAvailable()).forEach(i->System.out.println(i));

			try {
				dmi.bookShow(list, "Pathan", "12:00", 19);
				list.stream().map(i->i.getShowName()+" "+i.getShowTime()+" "+i.getSeatsAvailable()).forEach(i->System.out.println(i));
				
			} 
			
			catch(InvalidShowTimeException | SeatsNotAvailableException| UnknownShowException e) {
				System.out.println(e.getMessage());
			}
				
}
}

