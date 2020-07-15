package services;

import model.*;

public class FareCalculator extends Booking{
	public double book(Hotel hotel) {
		double totalFare=0;
		int totalDays = hotel.getTodate().getDayOfMonth() - hotel.getFromdate().getDayOfMonth();
	
		if(hotel.getTodate().isAfter(hotel.getFromdate())) {
			totalFare = totalDays*booking(hotel.getNoOfPersons(),hotel.getRates());
		}
		return totalFare;
	}
	public double book(Flight flight) {
		double totalFare=0;
		if(flight.getTriptype().equals("one-way"))
			totalFare = booking(flight.getNoOfPersons(),flight.getRates());
		else if(flight.getFrom().isBefore(flight.getTo()))
			totalFare = booking(flight.getNoOfPersons(),flight.getRates());
		else
			return 0;
		return totalFare;
	}
	public double book(Train train) {
		double totalFare=0;
		totalFare = booking(train.getNoOfPersons(),train.getRates());
		return totalFare;
	}
	public double book(Bus bus) {
		double totalFare=0;
		totalFare = booking(bus.getNoOfPersons(),bus.getRates());
		return totalFare;
	}
	
}