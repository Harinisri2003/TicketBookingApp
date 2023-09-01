package com.skcet.liveConcert.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skcet.liveConcert.model.Event;
import com.skcet.liveConcert.service.EventService;

@RestController
@RequestMapping("api/v1/event")
public class EventController {
	
	@Autowired
    private EventService eventService;
	@PutMapping("/putEvent/{eventId}")
  	public ResponseEntity<String> updateUser(@PathVariable Long eventId,@RequestBody Event event)
  	{
  		boolean EventData=eventService.updateEvent(eventId, event);
  		if(EventData)
  		{
  			return ResponseEntity.status(200).body("updated successfully");
  		}
  		else
  		{
  			return ResponseEntity.status(404).body("not updated successfully");
  		}
//  		return null;
  	}

}
