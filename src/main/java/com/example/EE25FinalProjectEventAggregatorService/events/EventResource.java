package com.example.EE25FinalProjectEventAggregatorService.events;

import com.example.EE25FinalProjectEventAggregatorService.entity.Event;
import jakarta.annotation.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/events")
public class EventResource {

    @Resource
    private EventService eventService;

    @GetMapping("/all")
    public ResponseEntity<List<Event>> getAllEvents() {
        List<Event> events = eventService.findAllEvents();
        return new ResponseEntity<>(events, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Event> getEmployeeById(@PathVariable("id") Integer id) {
        Event employee = eventService.findEventById(id);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }
}
