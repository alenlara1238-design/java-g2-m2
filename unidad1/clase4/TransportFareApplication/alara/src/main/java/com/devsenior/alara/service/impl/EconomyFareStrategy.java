package com.devsenior.alara.service.impl;

import org.springframework.stereotype.Component;

import com.devsenior.alara.service.FareStrategy;

@Component
public class EconomyFareStrategy implements FareStrategy {
    
    public double calculateFare(double distance, double duration) {
        return distance * 1.0 + duration * 0.5;
    }
}
