package com.pluralsight.springboot.tickets.models;

public record Venue(
        int id,
        String name,
        String street,
        String city,
        String country
) {
}
