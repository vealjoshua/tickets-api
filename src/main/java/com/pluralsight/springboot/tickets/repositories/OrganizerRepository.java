package com.pluralsight.springboot.tickets.repositories;

import com.pluralsight.springboot.tickets.models.Organizer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface OrganizerRepository extends JpaRepository<Organizer, Integer> {}
