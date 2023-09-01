package com.skcet.liveConcert.service;

import com.skcet.liveConcert.model.Event;

public interface EventService {
	public boolean updateEvent(Long eventId,Event event);
}
