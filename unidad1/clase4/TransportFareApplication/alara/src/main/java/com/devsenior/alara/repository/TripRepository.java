package com.devsenior.alara.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.devsenior.alara.model.Trip;

@Repository
public class TripRepository implements ITripRepository {
    private final List<Trip> trips = new ArrayList<>();
    private Long idCounter = 1L;


    @Override
    //agregamos un id manualmente y salvamos el viaje en la lista
    public Trip save(Trip trip){
        trip.setId(idCounter++);
        trips.add(trip);
        return trip;
    }

    @Override
    public List<Trip> findAll(){
        return trips;
    }

}
