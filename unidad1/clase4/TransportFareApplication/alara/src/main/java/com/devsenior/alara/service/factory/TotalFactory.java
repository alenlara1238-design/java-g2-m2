package com.devsenior.alara.service.factory;

import org.springframework.stereotype.Component;

import com.devsenior.alara.dto.TripRequest;
import com.devsenior.alara.model.FareType;
import com.devsenior.alara.service.impl.EconomyFareStrategy;
import com.devsenior.alara.service.impl.PremiumFareStrategy;
import com.devsenior.alara.service.impl.SurgeFareStrategy;

@Component
public class TotalFactory {

    private final EconomyFareStrategy economyFareStrategy;
    private final PremiumFareStrategy premiumFareStrategy;
    private final SurgeFareStrategy surgeFareStrategy;

    public TotalFactory(EconomyFareStrategy economyFareStrategy, PremiumFareStrategy premiumFareStrategy, SurgeFareStrategy surgeFareStrategy) {
        this.economyFareStrategy = economyFareStrategy;
        this.premiumFareStrategy = premiumFareStrategy;
        this.surgeFareStrategy = surgeFareStrategy;
    }

    public double calculateTotal(TripRequest tripRequest) {
        double distance = tripRequest.getDistance();
        double duration = tripRequest.getDuration();
        FareType fareType = FareType.valueOf(tripRequest.getFareType());
        
        // Aquí puedes implementar la lógica para calcular el total según el tipo de tarifa
        // Por ejemplo:
        switch (fareType) {
            case ECONOMY:
                   return  economyFareStrategy.calculateFare(distance, duration);
            case PREMIUM:
                    return premiumFareStrategy.calculateFare(distance, duration);
            case SURGE:
                    return surgeFareStrategy.calculateFare(distance, duration);
            default:
                throw new IllegalArgumentException("Tipo de tarifa no válido: " + fareType);
        }
    }
}
