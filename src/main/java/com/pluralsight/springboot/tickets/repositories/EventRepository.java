package com.pluralsight.springboot.tickets.repositories;

import com.pluralsight.springboot.tickets.models.Event;
import com.pluralsight.springboot.tickets.models.Organizer;
import com.pluralsight.springboot.tickets.models.Venue;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public class EventRepository {

    private final List<Event> events = List.of(
            new Event(
                    101,
                    "Globomatics Tech Conference",
                    new Organizer(101, "Globomatics", "Globomatics Technology Corporation"),
                    new Venue(201, "Globomatics Main Office", "Test Street 325", "New York", "USA"),
                    LocalDate.of(2023, 10, 2), LocalDate.of(2023, 10, 4)
            ),
            new Event(
                    502,
                    "Globomatics Developer Day",
                    new Organizer(101, "Globomatics", "Globomatics Technology Corporation"),
                    new Venue(201, "Globomatics Main Office", "Test Street 325", "New York", "USA"),
                    LocalDate.of(2024, 1, 10), LocalDate.of(2024, 1, 10)
            ),
            new Event(
                    503,
                    "Carbed Rock New Products Day",
                    new Organizer(102, "Carved Rock", "Carbed Rock Sports Equipment"),
                    new Venue(202, "Sea View Hotel", "Beach Boulevard 863", "Los Angeles", "USA"),
                    LocalDate.of(2024, 2, 29), LocalDate.of(2024, 2, 29)
            )
    );

    public List<Event> findByOrganizerId(int organizerId) {
        return events.stream().filter(event -> event.organizer().id() == organizerId).toList();
    }

    public Optional<Event> findById(int id) {
        return events.stream().filter(event -> event.id() == id).findAny();
    }
}
