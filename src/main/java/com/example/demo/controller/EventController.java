package com.example.demo.controller;

import com.example.demo.model.Event;
import com.example.demo.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/events")
public class EventController {
    @Autowired
    private EventService eventService;

    @GetMapping
    public List<Event> getAllEvents() {
        return eventService.getAllEvents();
    }

    @GetMapping("/{id}")
    public Event getEventById(@PathVariable String id) {
        return eventService.getEventById(id).get();
    }

    @PostMapping
    public Event createEvent(@RequestBody Event event) {
        return eventService.createEvent(event);
    }

    @DeleteMapping("/{id}")
    public void deleteEvent(@PathVariable String id) {
        eventService.deleteEvent(id);
    }

    @PutMapping("/{id}")
    public Event updateEvent(@PathVariable String id, @RequestBody Event event) {
        return eventService.updateEvent(id, event);
    }

    // obtener eventos por categoria id
    @GetMapping("/category/{categoryId}")
    public List<Event> getEventsByCategoryId(@PathVariable String categoryId) {
        return eventService.getEventsByCategoryId(categoryId);
    }

    // obtener eventos random
    @GetMapping("/random")
    public List<Event> getEventsRandom() {
        return eventService.getEventsRandom();
    }

    // obtener eventos por local
    @GetMapping("/local/{localId}")
    public List<Event> getEventsByLocalId(@PathVariable String localId) {
        return eventService.getEventsByLocalId(localId);
    }

    // obtener eventos por nombre
    @GetMapping("/name/like/{name}")
    public List<Event> getEventsByName(@PathVariable String name) {
        return eventService.getEventsByNameLike(name);
    }
}
