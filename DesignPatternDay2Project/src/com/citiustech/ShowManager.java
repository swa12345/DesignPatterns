package com.citiustech;

import java.util.List;

import com.citiustech.exceptions.InvalidShowTimeException;
import com.citiustech.exceptions.SeatsNotAvailableException;
import com.citiustech.exceptions.UnknownShowException;

public interface ShowManager
{
	public List<Show> populate();
	public void bookShow(List<Show> showList, String showName,String show_time, int noOfSeats) throws SeatsNotAvailableException,UnknownShowException,InvalidShowTimeException;
}
