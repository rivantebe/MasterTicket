package com.example.demo.controller;

import com.example.demo.model.EventLocation;
import com.example.demo.service.EventLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/event-locations")
public class EventLocationController {
    @Autowired
    private EventLocationService eventLocationService;

    @GetMapping
    public List<EventLocation> getAllEventLocations() {
        return eventLocationService.getAllEventLocations();
    }

    @GetMapping("/{id}")
    public Optional<EventLocation> getEventLocationById(@PathVariable String id) {
        return eventLocationService.getEventLocationById(id);
    }

    @PostMapping
    public EventLocation createEventLocation(@RequestBody EventLocation eventLocation) {
        return eventLocationService.createEventLocation(eventLocation);
    }

    @PutMapping("/{id}")
    public EventLocation updateEventLocation(@PathVariable String id, @RequestBody EventLocation eventLocation) {
        return eventLocationService.updateEventLocation(id, eventLocation);
    }

    @DeleteMapping("/{id}")
    public void deleteEventLocation(@PathVariable String id) {
        eventLocationService.deleteEventLocation(id);
    }
}
