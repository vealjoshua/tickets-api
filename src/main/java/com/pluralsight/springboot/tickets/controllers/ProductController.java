package com.pluralsight.springboot.tickets.controllers;

import com.pluralsight.springboot.tickets.models.Event;
import com.pluralsight.springboot.tickets.models.Product;
import com.pluralsight.springboot.tickets.repositories.ProductRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class ProductController {

    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping(path = "/products")
    public List<Product> getProductsByEvent(@RequestParam("eventId") int eventId) {
        return productRepository.findByEventId(eventId);
    }

    @GetMapping(path = "/products/{id}")
    public Product getProductById(@PathVariable("id") int id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Element with id " + id + " not found"));
    }
}
