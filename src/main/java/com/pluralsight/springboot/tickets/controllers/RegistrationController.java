package com.pluralsight.springboot.tickets.controllers;

import com.pluralsight.springboot.tickets.models.Event;
import com.pluralsight.springboot.tickets.models.EventsClient;
import com.pluralsight.springboot.tickets.models.Product;
import com.pluralsight.springboot.tickets.models.Registration;
import com.pluralsight.springboot.tickets.repositories.RegistrationRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.NoSuchElementException;
import java.util.UUID;

@RestController
@RequestMapping(path = "/registrations")
public class RegistrationController {

    private final EventsClient eventsClient;
    private final RegistrationRepository repository;

    public RegistrationController(EventsClient eventsClient, RegistrationRepository repository) {
        this.eventsClient = eventsClient;
        this.repository = repository;
    }

    @PostMapping
    public Registration create(@RequestBody @Valid Registration registration) {
        Product product = eventsClient.getProductById(registration.productId());
        Event event = eventsClient.getEventById(product.getEventId());
        String ticketCode = UUID.randomUUID().toString();
        return repository.save(new Registration(null, registration.productId(), event.getName(), product.getPrice(), ticketCode,  registration.attendeeName()));
    }

    @GetMapping(path = "/{ticketCode}")
    public Registration get(@PathVariable("ticketCode") String ticketCode) {
        return repository.findByTicketCode(ticketCode)
                .orElseThrow(() -> new NoSuchElementException("Registration with ticket code " + ticketCode + " not found"));
    }

    @PutMapping
    public Registration update(@RequestBody Registration registration) {
        String ticketCode = registration.ticketCode();
        var existing = repository.findByTicketCode(ticketCode)
                .orElseThrow(() -> new NoSuchElementException("Registration with ticket code " + ticketCode + " not found"));

        return repository.save(new Registration(existing.id(), existing.productId(), existing.eventName(), existing.amount(), existing.ticketCode(), registration.attendeeName()));
    }

    @DeleteMapping(path = "/{ticketCode}")
    public void delete(@PathVariable("ticketCode") String ticketCode) {
        repository.deleteByTicketCode(ticketCode);
    }
}
