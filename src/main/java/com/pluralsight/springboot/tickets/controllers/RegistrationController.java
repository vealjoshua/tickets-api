package com.pluralsight.springboot.tickets.controllers;

import com.pluralsight.springboot.tickets.models.Registration;
import com.pluralsight.springboot.tickets.repositories.RegistrationRepository;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;
import java.util.UUID;

@RestController
@RequestMapping(path = "/registrations")
public class RegistrationController {

    private final RegistrationRepository repository;

    public RegistrationController(RegistrationRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public Registration create(@RequestBody @Valid Registration registration) {
        String ticketCode = UUID.randomUUID().toString();
        return repository.save(new Registration(null, registration.productId(), ticketCode, registration.attendeeName()));
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

        return repository.save(new Registration(existing.id(), existing.productId(), existing.ticketCode(), registration.attendeeName()));
    }

    @DeleteMapping(path = "/{ticketCode}")
    public void delete(@PathVariable("ticketCode") String ticketCode) {
        repository.deleteByTicketCode(ticketCode);
    }
}
