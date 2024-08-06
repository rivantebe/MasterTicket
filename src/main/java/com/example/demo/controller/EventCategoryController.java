package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.EventCategory;
import com.example.demo.service.EventCategoryService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/event-categories")
public class EventCategoryController {
    @Autowired
    private EventCategoryService eventCategoryService;

    // Crear una categoría
    @PostMapping
    public void createEventCategory(@RequestBody EventCategory eventCategory) {
        eventCategoryService.createEventCategory(eventCategory);
    }

    // Obtener todas las categorías
    @GetMapping
    public List<EventCategory> getAllEventCategories() {
        return eventCategoryService.getAllEventCategories();
    }

    // Obtener una categoría por id
    @GetMapping("/{id}")
    public EventCategory getEventCategoryById(@PathVariable String id) {
        return eventCategoryService.getEventCategoryById(id);
    }

    // Actualizar una categoría
    @PutMapping("/{id}")
    public void updateEventCategory(@PathVariable String id, @RequestBody EventCategory eventCategory) {
        eventCategoryService.updateEventCategory(id, eventCategory);
    }

    // Eliminar una categoría
    @DeleteMapping("/{id}")
    public void deleteEventCategory(@PathVariable String id) {
        eventCategoryService.deleteEventCategory(id);
    }
}
