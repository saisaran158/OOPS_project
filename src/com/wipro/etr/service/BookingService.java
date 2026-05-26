package com.wipro.etr.service;

import java.util.ArrayList;

import com.wipro.etr.entity.Booking;
import com.wipro.etr.entity.Event;
import com.wipro.etr.entity.User;
import com.wipro.etr.util.EventFullException;
import com.wipro.etr.util.EventNotFoundException;
import com.wipro.etr.util.InvalidUserException;

public class BookingService {

	private ArrayList<User> user;
	private ArrayList<Event> events;
	private ArrayList<Booking> booking;

	public BookingService(ArrayList<User> user, ArrayList<Event> events, ArrayList<Booking> booking) {
		super();
		this.user = user;
		this.events = events;
		this.booking = booking;
	}
	
	
	public boolean validateUser(String userId) throws InvalidUserException{
		for(User i : user) {
			if(i.getUserId().equals(userId))
				return true;
		}
		throw new InvalidUserException();
	}
	
	public Event findEvent(String eventId) throws EventNotFoundException {
		for(Event i : events) {
			if(i.getEventId().equals(eventId)) {
				return i;
			}
		}
		throw new EventNotFoundException();
	}
	public double calculateFare(Event event, int seats) throws EventFullException {
		if(event.getAvailableSeats()>seats) {
			return event.getTicketPrice()*seats;
		}
		throw new EventFullException();
	}

	
}
