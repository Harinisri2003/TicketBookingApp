package com.skcet.liveConcert.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="_venue")
public class Venue {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
      private Long id;
      private String venueName;
      private String location;
      private String seatingCapacity;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getVenueName() {
		return venueName;
	}
	public void setVenueName(String venueName) {
		this.venueName = venueName;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getSeatingCapacity() {
		return seatingCapacity;
	}
	public void setSeatingCapacity(String seatingCapacity) {
		this.seatingCapacity = seatingCapacity;
	}
	public Venue(Long id, String venueName, String location, String seatingCapacity) {
		super();
		this.id = id;
		this.venueName = venueName;
		this.location = location;
		this.seatingCapacity = seatingCapacity;
	}
	public Venue() {
		super();
	}
	
}
