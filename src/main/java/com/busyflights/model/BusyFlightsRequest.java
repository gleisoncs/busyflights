package com.busyflights.model;

/**
 * This class is a VO to BusyFlightsRequest
 * <p>
 * Created by gleisoncs on 01/29/2016.
 */
public class BusyFlightsRequest {

	private String origin;
	private String destination;
	private String departureDate;
	private String returnDate;
	private int numberOfPassengers;

	public BusyFlightsRequest() {
	}

	public BusyFlightsRequest(String origin, String destination, String departureDate, String returnDate,
			String numberOfPassengers) {

		this.origin = origin;
		this.destination = destination;
		this.departureDate = departureDate;
		this.returnDate = returnDate;
		this.numberOfPassengers = Integer.parseInt(numberOfPassengers);
	}

	public String getOrigin() {
		return origin;
	}

	public String getDestination() {
		return destination;
	}

	public String getDepartureDate() {
		return departureDate;
	}

	public String getReturnDate() {
		return returnDate;
	}

	public int getNumberOfPassengers() {
		return numberOfPassengers;
	}
}
