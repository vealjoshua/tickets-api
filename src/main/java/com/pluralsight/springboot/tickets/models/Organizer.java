package com.pluralsight.springboot.tickets.models;

public record Organizer(
        int id,
        String name,
        String description
) {
}
