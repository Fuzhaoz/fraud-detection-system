package com.frauddetection.frauddetectionapi.model;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;
@Data
public class TransactionRequest {

    @NotNull(message = "Features cannot be null")
    private List<Double> features;

}
