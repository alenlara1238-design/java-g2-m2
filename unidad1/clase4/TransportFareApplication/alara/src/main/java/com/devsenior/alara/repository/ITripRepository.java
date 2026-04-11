package com.devsenior.alara.repository;

import com.devsenior.alara.model.Trip;

public interface ITripRepository {
    public Trip save(Trip trip);
    public java.util.List<Trip> findAll();
}
