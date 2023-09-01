package com.skcet.liveConcert.model;

import java.sql.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="_booking")
public class Bookings {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private double ticketPrice;
        private int quantity;
        @DateTimeFormat(pattern = "yyyy-MM-dd")
        @Column(name = "date")
        private Date bookingDate;
        
        @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
        @JoinColumn
        private Payment payment;
        
		
		public Payment getPayment() {
			return payment;
		}
		public void setPayment(Payment payment) {
			this.payment = payment;
		}
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public double getTicketPrice() {
			return ticketPrice;
		}
		public void setTicketPrice(double ticketPrice) {
			this.ticketPrice = ticketPrice;
		}
		public int getQuantity() {
			return quantity;
		}
		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}
		public Date getBookingDate() {
			return bookingDate;
		}
		public void setBookingDate(Date bookingDate) {
			this.bookingDate = bookingDate;
		}
		public Bookings(Long id, double ticketPrice, int quantity, Date bookingDate) {
			super();
			this.id = id;
			this.ticketPrice = ticketPrice;
			this.quantity = quantity;
			this.bookingDate = bookingDate;
		}
		public Bookings() {
			super();
		}
		
}
