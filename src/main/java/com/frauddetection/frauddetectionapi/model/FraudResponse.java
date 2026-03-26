package com.frauddetection.frauddetectionapi.model;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FraudResponse {
        private boolean isFraud;
        private double confidence;
        private String message;
    }

