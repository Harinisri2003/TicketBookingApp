package com.skcet.liveConcert.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skcet.liveConcert.model.Event;
import com.skcet.liveConcert.repository.EventRepository;

import jakarta.transaction.Transactional;



@Service
@Transactional
public class EventServiceImpl implements EventService{

	@Autowired
	private EventRepository eventRepository;
	@Override
	public boolean updateEvent(Long eventId, Event event) {
		Optional<Event> existingUserOptional=eventRepository.findByEventId(eventId);
		System.out.println(event.getEventName());
		if(existingUserOptional.isPresent())
		{
		Event concertExists=existingUserOptional.get();
		concertExists.setDescription(event.getDescription());
		concertExists.setEventDate(event.getEventDate());
		concertExists.setEventName(event.getEventName());
		concertExists.setTicketPrice(event.getTicketPrice());
		concertExists.setTicketQuantity(event.getTicketQuantity());
		eventRepository.save(concertExists);
		return true;
		} else
		{
			return false;
		}
	}

}
