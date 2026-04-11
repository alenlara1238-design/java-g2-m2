package com.devsenior.alara.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsenior.alara.dto.TripRequest;
import com.devsenior.alara.model.Trip;
import com.devsenior.alara.service.ItripService;

import jakarta.validation.Valid;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/trips")
public class TripController implements ITripController {

    private final ItripService service;
    
    public TripController(ItripService service) {
        this.service = service;
    }

    
    @Override
    @PostMapping
    public ResponseEntity<Trip> createTrip(@Valid @RequestBody TripRequest request) {
        Trip trip = service.createTrip(request);
        return ResponseEntity.status(201).body(trip);
        
    }

    @Override
    @GetMapping
    public ResponseEntity<List<Trip>> listTrips() {
        List<Trip> trips = service.listTrips();
        return ResponseEntity.ok(trips);
    }
    
}
