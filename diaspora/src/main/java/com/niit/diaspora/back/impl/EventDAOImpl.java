package com.niit.diaspora.back.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.diaspora.back.dao.EventDAO;
import com.niit.diaspora.back.model.Event;

@Repository("eventDAO")
public class EventDAOImpl implements EventDAO {
	@Autowired
	SessionFactory sessionFactory;

	public EventDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public void saveOrUpdateEvent(Event event) {
		sessionFactory.getCurrentSession().saveOrUpdate(event);

	}

	@Transactional
	public void deleteEvent(String eventId) {
		Event eventToDelete = new Event();
		eventToDelete.setEventId(eventId);
		sessionFactory.getCurrentSession().delete(eventToDelete);
	}

	@Transactional
	public Event getEvent(String eventId) {
		String hql = "from Event where eventId=:eventId";
		Query query = sessionFactory.getCurrentSession().createQuery(hql).setParameter("eventId", eventId);
		List<Event> gotEvent = query.getResultList();
		if (gotEvent != null && !gotEvent.isEmpty())
			return gotEvent.get(0);
		return null;
	}

	@Transactional
	public List<Event> listEvents() {
		String hql = "from Event";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<Event> listOfEvents = query.getResultList();
		return listOfEvents;
	}
	
	@Transactional
	public List<Event> listEventByEventAt(){
	
		String hql = "from Event e where eventAt >=:eventDate ORDER BY e.eventAt ASC";
		Query query = sessionFactory.getCurrentSession().createQuery(hql).setParameter("eventDate",new Date());
		List<Event> listOfEvents = query.getResultList();
		return listOfEvents;
	}

}
