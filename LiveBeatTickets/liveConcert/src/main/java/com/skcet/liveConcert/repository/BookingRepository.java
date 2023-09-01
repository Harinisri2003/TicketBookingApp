package com.skcet.liveConcert.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.skcet.liveConcert.model.Bookings;

public interface BookingRepository extends JpaRepository<Bookings, Long>{
    
	@Query("select b from Bookings b")
	List<Bookings> findAllQuery();
}
