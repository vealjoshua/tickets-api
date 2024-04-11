package com.pluralsight.springboot.tickets.models;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record Registration(
        Integer id,
        @NotNull(message = "Product id is required") Integer productId,
        String ticketCode,
        @NotBlank String attendeeName
) {
}
