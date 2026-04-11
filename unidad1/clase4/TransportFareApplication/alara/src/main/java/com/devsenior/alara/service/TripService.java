package com.devsenior.alara.service;

import java.util.Comparator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.devsenior.alara.dto.TripRequest;
import com.devsenior.alara.model.FareType;
import com.devsenior.alara.model.Trip;
import com.devsenior.alara.repository.ITripRepository;
import com.devsenior.alara.repository.TripRepository;
import com.devsenior.alara.service.factory.TotalFactory;
import com.devsenior.alara.service.impl.EconomyFareStrategy;
import com.devsenior.alara.service.impl.PremiumFareStrategy;
import com.devsenior.alara.service.impl.SurgeFareStrategy;

@Service
public class TripService implements ItripService {
    private final ITripRepository tripRepository;
    private final TotalFactory totalFactory;
    
    public TripService(ITripRepository tripRepository, TotalFactory totalFactory) {
        this.tripRepository = tripRepository;
        this.totalFactory = totalFactory;
    }

    @Override
    //aqui el service recibirá del contorlador el TripRequest, que es un DTO con los datos necesarios para calcular la tarifa y crear el viaje. El service se encargará de determinar la estrategia de tarifa a utilizar, calcular el total y guardar el viaje en la base de datos.
    public Trip createTrip(TripRequest tripRequest) {
        // Determine fare strategy based on trip request
        FareType fareType = FareType.valueOf(tripRequest.getFareType());
        double total = totalFactory.calculateTotal(tripRequest);
       
        Trip trip = new Trip();
        trip.setDistance(tripRequest.getDistance());
        trip.setDuration(tripRequest.getDuration());
        trip.setFareType(fareType);
        trip.setTotalFare(total);
        trip.setUserEmail(tripRequest.getUserEmail());

        return tripRepository.save(trip);
    }


    @Override
    // El service devuelve una lista de Trip (modelo). El service solo devuelve modelos, no DTOs. El controlador se encargará de convertir los modelos a DTOs antes de enviarlos al cliente.
    public List<Trip> listTrips() {
               return tripRepository.findAll()
                .stream()
                .sorted(Comparator.comparing(Trip::getTotalFare).reversed()) // Ordenar por ID de forma descendente
                .toList();
            }


}
