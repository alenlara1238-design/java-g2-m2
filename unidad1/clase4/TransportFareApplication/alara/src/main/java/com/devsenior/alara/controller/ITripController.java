package com.devsenior.alara.controller;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.http.ResponseEntity;

import com.devsenior.alara.dto.TripRequest;
import com.devsenior.alara.model.Trip;

public interface ITripController {
    public ResponseEntity<Trip> createTrip(TripRequest request);
    public ResponseEntity<List<Trip>> listTrips();
}
