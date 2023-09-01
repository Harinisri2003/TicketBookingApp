package com.skcet.liveConcert.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


import com.skcet.liveConcert.model.Event;



public interface EventRepository extends JpaRepository<Event,Integer>{
	Optional<Event> findByEventId(Long eventId);
}
