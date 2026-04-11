package com.devsenior.alara.service;

import java.util.List;

import com.devsenior.alara.dto.TripRequest;
import com.devsenior.alara.model.Trip;

public interface ItripService {
    public Trip createTrip(TripRequest tripRequest);
    public List<Trip> listTrips();
}
