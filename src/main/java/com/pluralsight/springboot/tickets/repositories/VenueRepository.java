package com.pluralsight.springboot.tickets.repositories;

import com.pluralsight.springboot.tickets.models.Venue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VenueRepository extends JpaRepository<Venue, Integer> {
}