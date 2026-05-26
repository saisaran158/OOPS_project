package com.wipro.etr.main;

import java.util.ArrayList; 
import com.wipro.etr.entity.*; 
import com.wipro.etr.service.BookingService; 
import com.wipro.etr.util.*; 
 
public class Main { 
    public static void main(String[] args) { 
 
        ArrayList<User> users = new ArrayList<>(); 
        users.add(new User("U001", "Manoj Kumar", "9876543210")); 
        users.add(new User("U002", "Sneha Reddy", "9123456780")); 
 
        ArrayList<Event> events = new ArrayList<>(); 
        events.add(new Event("E101", "Music Fest 2025", "2025-12-18", 200, 200, 1500.0)); 
        events.add(new Event("E202", "Tech Conference", "2025-11-10", 300, 300, 2500.0)); 
 
        ArrayList<Booking> bookings = new ArrayList<>(); 
 
        BookingService service = new BookingService(users, events, bookings); 
 
       
        try {
			System.out.println(service.validateUser("U002"));
			System.out.println(service.findEvent("E202"));
			System.out.println(service.calculateFare(events.get(0), 250));
		} catch (InvalidUserException | EventNotFoundException |EventFullException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    } 
} 
