package com.pluralsight.springboot.tickets.repositories;

import com.pluralsight.springboot.tickets.models.Event;
import com.pluralsight.springboot.tickets.models.Organizer;
import com.pluralsight.springboot.tickets.models.Venue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface EventRepository extends JpaRepository<Event, Integer> {

    List<Event> findByOrganizerId(int organizerId);
}
