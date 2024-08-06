package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.EventCategory;
import com.example.demo.repository.EventCategoryRepository;

@Service
public class EventCategoryService {
    @Autowired
    private EventCategoryRepository eventCategoryRepository;

    // Crear una categoría
    public EventCategory createEventCategory(EventCategory eventCategory) {
        return eventCategoryRepository.save(eventCategory);
    }

    // Obtener todas las categorías
    public List<EventCategory> getAllEventCategories() {
        return eventCategoryRepository.findAll();
    }

    // Obtener una categoría por id
    public EventCategory getEventCategoryById(String id) {
        return eventCategoryRepository.findById(id).get();
    }

    // Actualizar una categoría
    public EventCategory updateEventCategory(String id, EventCategory eventCategory) {
        EventCategory eventCategoryToUpdate = eventCategoryRepository.findById(id).get();
        eventCategoryToUpdate.setName(eventCategory.getName());
        return eventCategoryRepository.save(eventCategoryToUpdate);
    }

    // Eliminar una categoría
    public void deleteEventCategory(String id) {
        eventCategoryRepository.deleteById(id);
    }
}
