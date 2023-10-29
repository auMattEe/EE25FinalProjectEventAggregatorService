package com.example.EE25FinalProjectEventAggregatorService.events;

import com.example.EE25FinalProjectEventAggregatorService.entity.Event;
import com.example.EE25FinalProjectEventAggregatorService.exception.UserNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class EventService {

    private final EventRepo eventRepo;

    @Autowired
    public EventService(EventRepo eventRepo) {
        this.eventRepo = eventRepo;
    }

    public List<Event> findAllEvents() {
        return eventRepo.findAll();
    }

    public Event findEventById(Integer id) {
        return eventRepo.findEventById(id)
                .orElseThrow(() -> new UserNotFoundException("User by id " + id + " was not found."));
    }

    public Event createEvent(Event event) {
        return eventRepo.save(event);
    }

    public Event updateEvent(Event event) {
        return eventRepo.save(event);
    }

    public void deleteEvent(Integer id) {
        eventRepo.deleteEvenetById(id);
    }
}
