package com.nstanogias.knapsack.payload;

import lombok.Data;

/**
 * Created by nickstanogias on 17/11/18.
 */
@Data
public class JwtAuthenticationResponse {
    private String accessToken;
    private String tokenType = "Bearer";

    public JwtAuthenticationResponse(String accessToken) {
        this.accessToken = accessToken;
    }
}
