package com.niit.diaspora.back.dao;

import java.util.List;

import com.niit.diaspora.back.model.Event;

public interface EventDAO {

	void saveOrUpdateEvent(Event event);
	
	void deleteEvent(String eventId);
	
	Event getEvent(String eventId);
	
	List<Event> listEvents();
	
	List<Event> listEventByEventAt();
}
