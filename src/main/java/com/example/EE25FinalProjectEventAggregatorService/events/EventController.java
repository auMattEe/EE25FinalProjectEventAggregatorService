package com.example.EE25FinalProjectEventAggregatorService.events;

import com.example.EE25FinalProjectEventAggregatorService.entity.Event;
import com.example.EE25FinalProjectEventAggregatorService.entity.User;
import com.example.EE25FinalProjectEventAggregatorService.events.dto.CreatedEvent;
import com.example.EE25FinalProjectEventAggregatorService.user.dto.RegistrationRequest;
import jakarta.annotation.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public ResponseEntity<Event> getEventById(@RequestParam int id) {
        Event event = eventService.findEventById(id);
        return new ResponseEntity<>(event, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Map<String, String>> addEvent(@RequestBody CreatedEvent createdEvent) {
        Event newEvent = new Event();
        newEvent.setName(createdEvent.getName());
        newEvent.setEventStart(createdEvent.getEventStart());
        newEvent.setEventDuration(createdEvent.getEventDuration());
        newEvent.setAddress(createdEvent.getAddress());
        newEvent.setDescription(createdEvent.getDescription());

        boolean creationResult = eventService.createEvent(newEvent);

        Map<String, String> response = new HashMap<>();
        if (creationResult) {
            response.put("message", "Event created successful");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            response.put("message", "Creating event failed");
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<Event> updateEvent(@RequestBody Event event) {
        Event updatedEvent = eventService.updateEvent(event);
        return new ResponseEntity<>(updatedEvent, HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteEvent(@RequestParam int id) {
        eventService.deleteEvent(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
