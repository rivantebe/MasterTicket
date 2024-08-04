package com.example.demo.service;

import com.example.demo.model.EventLocation;
import com.example.demo.repository.EventLocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventLocationService {
    @Autowired
    private EventLocationRepository eventLocationRepository;

    public List<EventLocation> getAllEventLocations() {
        return eventLocationRepository.findAll();
    }

    public Optional<EventLocation> getEventLocationById(String id) {
        return eventLocationRepository.findById(id);
    }

    public EventLocation createEventLocation(EventLocation eventLocation) {
        return eventLocationRepository.save(eventLocation);
    }

    public EventLocation updateEventLocation(String id, EventLocation eventLocation) {
        eventLocation.setId(id);
        return eventLocationRepository.save(eventLocation);
    }

    public void deleteEventLocation(String id) {
        eventLocationRepository.deleteById(id);
    }
}
