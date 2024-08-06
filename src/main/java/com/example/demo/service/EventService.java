package com.example.demo.service;

import com.example.demo.model.Event;
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

    // obtener eventos por nombre de categoria
    public List<Event> getEventsByCategoryId(String categoryId) {
        return eventRepository.findByEventCategoryId(categoryId);
    }

    // obtener eventos modo random en cada nueva petición
    public List<Event> getEventsRandom() {
        // reordenar la lista de eventos de forma aleatoria
        List<Event> events = eventRepository.findAll();

        for (int i = 0; i < events.size(); i++) {
            int randomIndex = (int) (Math.random() * events.size());
            Event temp = events.get(i);
            events.set(i, events.get(randomIndex));
            events.set(randomIndex, temp);
        }

        return events;
    }

    // obtener eventos por local
    public List<Event> getEventsByLocalId(String localId) {
        return eventRepository.findByEventLocationId(localId);
    }

    // Bucar eventos por nombre
    public List<Event> getEventsByNameLike(String name) {
        return eventRepository.findByNameLike(name);
    }
}
