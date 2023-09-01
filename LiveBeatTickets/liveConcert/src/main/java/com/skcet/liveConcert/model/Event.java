package com.skcet.liveConcert.model;

import java.sql.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
@Entity
@Table(name="_event")
public class Event {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int eventId;
    private String eventName;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "date")
    private Date eventDate;
    private String description;
    private double ticketPrice;
    private int ticketQuantity;
    
    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn
     private Venue venue;
    
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name="eventbookingId",referencedColumnName = "eventId")
    private List<Bookings> bookings;
    
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
 	@JoinColumn(name = "eventReviewId", referencedColumnName = "eventId")
 	private List<Review> review;
    
    
	public Event() {
		super();
	}
	
	public Event(int eventId, String eventName, int venue_id, Date eventDate, String description,
			double ticketPrice, int ticketQuantity) {
		super();
		this.eventId = eventId;
		this.eventName = eventName;
		this.eventDate = eventDate;
		this.description = description;
		this.ticketPrice = ticketPrice;
		this.ticketQuantity = ticketQuantity;
	}
	
	
	public int getEventId() {
		return eventId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

	public Venue getVenue() {
		return venue;
	}

	public void setVenue(Venue venue) {
		this.venue = venue;
	}

	public String getEventName() {
		return eventName;
	}
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	public Date getEventDate() {
		return eventDate;
	}
	public void setEventDate(Date eventDate) {
		this.eventDate = eventDate;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getTicketPrice() {
		return ticketPrice;
	}
	public void setTicketPrice(double ticketPrice) {
		this.ticketPrice = ticketPrice;
	}
	public int getTicketQuantity() {
		return ticketQuantity;
	}
	public void setTicketQuantity(int ticketQuantity) {
		this.ticketQuantity = ticketQuantity;
	}

	public List<Review> getReview() {
		return review;
	}

	public void setReview(List<Review> review) {
		this.review = review;
	}

	public List<Bookings> getBookings() {
		return bookings;
	}

	public void setBookings(List<Bookings> bookings) {
		this.bookings = bookings;
	}
    
    
}
