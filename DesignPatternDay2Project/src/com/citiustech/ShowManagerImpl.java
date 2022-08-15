package com.citiustech;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

import com.citiustech.exceptions.InvalidShowTimeException;
import com.citiustech.exceptions.SeatsNotAvailableException;
import com.citiustech.exceptions.UnknownShowException;

public class ShowManagerImpl {

	private static List<Show> showList = new ArrayList<Show>();

	public List<Show> populate(String filename) throws IOException {
//		should handle  FileNotFoundException, IOException, ClassNotFoundException 
//		path :"C:\\Users\\SwapnilK7\\Downloads\\booking.txt"
		File file = new File(filename);
		Scanner rf = new Scanner(file);

		StringTokenizer token = null;

		String showName = "";
		String show_time = "";
		int noOfSeats = 0;

		while (rf.hasNextLine()) {
			token = new StringTokenizer(rf.nextLine(), ",");

			showName = token.nextToken();
			show_time = token.nextToken();
			noOfSeats = Integer.parseInt(token.nextToken());

			Show sh = new Show(showName, show_time, noOfSeats);

			showList.add(sh);

		}
		return showList;
	}

	List<Show> isValidShow(List<Show> showList, String showName) {
		return showList.stream().filter(i -> i.getShowName().equalsIgnoreCase(showName)).collect(Collectors.toList());

	}

	boolean isShowAvailable(List<Show> showList, String showName, String show_time) {
		return showList.stream().anyMatch(
				i -> i.getShowName().equalsIgnoreCase(showName) && i.getShowTime().equalsIgnoreCase(show_time));

	}

	boolean isSeatAvailable(List<Show> showList, String showName, String show_time, int noOfSeats) {
		return showList.stream().anyMatch(i -> i.getShowName().equalsIgnoreCase(showName)
				&& i.getShowTime().equalsIgnoreCase(show_time) && i.getSeatsAvailable() > noOfSeats);

	}

	public void bookShow(List<Show> showList, String showName, String show_time, int noOfSeats)
			throws SeatsNotAvailableException, UnknownShowException, InvalidShowTimeException {

		List<Show> listofShows = isValidShow(showList, showName);

		if (listofShows.size() == 0) {
			throw new UnknownShowException("This Show is currently not available");
		}
		if (!isShowAvailable(listofShows, showName, show_time)) {
			throw new InvalidShowTimeException("Show with this time is currently not available");
		}
		if (!isSeatAvailable(listofShows, showName, show_time, noOfSeats)) {
			throw new SeatsNotAvailableException("Seats are not available for this show");
		}

		System.out.println("Booking is successful");
		System.out.println("++++++++++++++++++++++++");
		System.out.println("Your Booking Details : " + showName + " " + show_time + " " + noOfSeats + " ticketsBooked");
		System.out.println("++++++++++++++++++++++++");

		updateAvailableSeats(showName, show_time, noOfSeats);

	}

	public void updateAvailableSeats(String showName, String show_time, int noOfSeats) {

		showList.forEach(i -> {
			if (i.getShowName().equalsIgnoreCase(showName) && i.getShowTime().equalsIgnoreCase(show_time)) {
				i.setSeatsAvailable(i.getSeatsAvailable() - noOfSeats);
			}
		});
	}

}
