package com.frauddetection.frauddetectionapi.controller;

import com.frauddetection.frauddetectionapi.model.FraudResponse;
import com.frauddetection.frauddetectionapi.model.TransactionRequest;
import com.frauddetection.frauddetectionapi.service.FraudDetectionService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/transactions")
public class FraudController {
    private final FraudDetectionService fraudDetectionService;


    public FraudController(FraudDetectionService fraudDetectionService) {
        this.fraudDetectionService = fraudDetectionService;
    }

    @PostMapping("/predict")
    public ResponseEntity<FraudResponse> predict (@Valid @RequestBody TransactionRequest request){
        FraudResponse fraudResponse = fraudDetectionService.predictFraud(request);
        return ResponseEntity.ok(fraudResponse);

    }


}
