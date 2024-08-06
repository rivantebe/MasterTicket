package com.example.demo.repository;

import com.example.demo.model.Event;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends MongoRepository<Event, String> {
    List<Event> findByEventCategoryId(String categoryId);
    List<Event> findByEventLocationId(String localId);
    @Query("{ 'name': { $regex: ?0, $options: 'i' } }")
    List<Event> findByNameLike(String name);
}
