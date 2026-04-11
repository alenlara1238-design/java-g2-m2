package com.devsenior.alara.service.impl;

import org.springframework.stereotype.Component;

import com.devsenior.alara.service.FareStrategy;

@Component
public class PremiumFareStrategy implements FareStrategy {

    private static final double PREMIUM_MULTIPLIER = 2.0;

    @Override
    public double calculateFare(double distance , double duration) {
        double baseFare = distance * PREMIUM_MULTIPLIER + duration * 1.0;
        return baseFare;
        
    }

}
