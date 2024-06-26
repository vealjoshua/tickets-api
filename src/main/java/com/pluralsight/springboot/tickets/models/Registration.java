package com.pluralsight.springboot.tickets.models;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Document("registrations")
public record Registration(
        @Id String id,
        @NotNull(message = "Product id is required") Integer productId,
        String eventName,
        BigDecimal amount,
        String ticketCode,
        @NotBlank String attendeeName
) {
}
