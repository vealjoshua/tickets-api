package com.pluralsight.springboot.tickets.repositories;

import com.pluralsight.springboot.tickets.models.Organizer;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrganizerRepository {

    private final List<Organizer> organizers = List.of(
            new Organizer(101, "Globomatics", "Globomatics Technology Corporation"),
            new Organizer(102, "Carved Rock", "Carved Rock Sports Equipment")
    );

    public List<Organizer> findAll() { return organizers; }
}
