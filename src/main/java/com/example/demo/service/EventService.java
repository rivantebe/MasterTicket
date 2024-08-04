package com.example.demo.service;

import com.example.demo.model.Event;
import com.example.demo.model.EventLocation;
import com.example.demo.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventService {
    @Autowired
    private EventRepository eventRepository;

    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    public Event createEvent(Event event) {
        return eventRepository.save(event);
    }

    public Optional<Event> getEventById(String id) {
        return eventRepository.findById(id);
    }

    // Eliminar un evento
    public void deleteEvent(String id) {
        eventRepository.deleteById(id);
    }

    // Actualizar un evento
    public Event updateEvent(String id, Event event) {
        Event eventToUpdate = eventRepository.findById(id).get();
        eventToUpdate.setName(event.getName());
        eventToUpdate.setDate(event.getDate());
        return eventRepository.save(eventToUpdate);
    }
}
