package com.skcet.liveConcert.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.skcet.liveConcert.model.Bookings;
import com.skcet.liveConcert.service.BookingService;

@RestController
@RequestMapping("api/v1/booking")
public class BookingController {
       @Autowired
       private BookingService bookingService;
       
       @GetMapping("/getbooking")
      	public ResponseEntity<List<Bookings>> getBookings(){
      		return ResponseEntity.status(200).body(bookingService.getValue());
      	}
       
       
        
}
