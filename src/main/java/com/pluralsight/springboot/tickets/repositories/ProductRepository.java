package com.pluralsight.springboot.tickets.repositories;

import com.pluralsight.springboot.tickets.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    List<Product> findByEventId(int eventId);
}
