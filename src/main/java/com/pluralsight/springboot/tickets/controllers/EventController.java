package com.pluralsight.springboot.tickets.controllers;

import com.pluralsight.springboot.tickets.models.Event;
import com.pluralsight.springboot.tickets.models.Organizer;
import com.pluralsight.springboot.tickets.models.Product;
import com.pluralsight.springboot.tickets.repositories.EventRepository;
import com.pluralsight.springboot.tickets.repositories.OrganizerRepository;
import com.pluralsight.springboot.tickets.repositories.ProductRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class EventController {

    private final EventRepository eventRepository;
    private final OrganizerRepository organizerRepository;

    public EventController(OrganizerRepository organizerRepository, EventRepository eventRepository) {
        this.eventRepository = eventRepository;
        this.organizerRepository = organizerRepository;
    }

    @GetMapping(path = "/organizers")
    public List<Organizer> getOrganizers() { return organizerRepository.findAll(); }

    @GetMapping(path = "/events")
    public List<Event> getEventsByOrganizer(@RequestParam("organizerId") int organizerId) {
        return eventRepository.findByOrganizerId(organizerId);
    }

    @GetMapping(path = "/events/{id}")
    public Event getEventById(@PathVariable("id") int eventId) {
        return eventRepository.findById(eventId)
                .orElseThrow(() -> new NoSuchElementException("Element with id " + eventId + " not found"));
    }
}
