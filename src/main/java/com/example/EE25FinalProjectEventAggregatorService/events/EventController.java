package com.example.EE25FinalProjectEventAggregatorService.events;

import com.example.EE25FinalProjectEventAggregatorService.entity.Event;
import jakarta.annotation.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/events")
public class EventController {

    @Resource
    private EventService eventService;

    @GetMapping("/all")
    public ResponseEntity<List<Event>> getAllEvents() {
        List<Event> events = eventService.findAllEvents();
        return new ResponseEntity<>(events, HttpStatus.OK);
    }

    @GetMapping("/event")
    public ResponseEntity<Event> getEmployeeById(@RequestParam Integer id) {
        Event employee = eventService.findEventById(id);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }
}
