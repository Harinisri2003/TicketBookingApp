package com.skcet.liveConcert.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skcet.liveConcert.model.Bookings;
import com.skcet.liveConcert.repository.BookingRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class BookingServiceImpl implements BookingService{
      @Autowired
      private BookingRepository bookingRepository;

	@Override
	public List<Bookings> getValue() {
		// TODO Auto-generated method stub
		return bookingRepository.findAllQuery();
		}
      
      
}
