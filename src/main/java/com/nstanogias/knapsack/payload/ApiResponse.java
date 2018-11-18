package com.nstanogias.knapsack.payload;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created by nickstanogias on 17/11/18.
 */
@Data
@AllArgsConstructor
public class ApiResponse {
    private Boolean success;
    private String message;
}
