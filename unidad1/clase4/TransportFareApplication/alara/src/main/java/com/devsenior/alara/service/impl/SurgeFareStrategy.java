package com.devsenior.alara.service.impl;

import org.springframework.stereotype.Component;

import com.devsenior.alara.service.FareStrategy;

@Component
public class SurgeFareStrategy  implements FareStrategy {

   private static final double SURGE_MULTIPLIER = 1.5; // Example surge multiplier

    @Override
    public double calculateFare(double distance, double duration) {
        return (distance * 1.5 + duration * 0.75) * SURGE_MULTIPLIER; // Example fare calculation with surge
    }

}
