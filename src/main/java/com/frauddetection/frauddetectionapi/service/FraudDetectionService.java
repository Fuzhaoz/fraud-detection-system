package com.frauddetection.frauddetectionapi.service;

import com.frauddetection.frauddetectionapi.model.FraudResponse;
import com.frauddetection.frauddetectionapi.model.TransactionRequest;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.Map;

@Service
public class FraudDetectionService {
    // RestClient pointing to Python Flask API
    private final RestClient restClient;

    // Constructor injection style (consistent with your course)
    public FraudDetectionService() {
        this.restClient = RestClient.create("http://localhost:5000");
    }

    public FraudResponse predictFraud(TransactionRequest request) {
        Map response = restClient.post()
                .uri("/predict")
                .contentType(MediaType.APPLICATION_JSON)
                .body(Map.of("features", request.getFeatures()))
                .retrieve()
                .body(Map.class);

// Parse Flask response
        boolean isFraud = (boolean) response.get("isFraud");
        double confidence = ((Number) response.get("confidence")).doubleValue();
        String message = (String) response.get("message");

        // Return result as FraudResponse
        return new FraudResponse(isFraud, confidence, message);
    }



}
