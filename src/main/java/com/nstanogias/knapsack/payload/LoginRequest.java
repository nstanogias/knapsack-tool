package com.nstanogias.knapsack.payload;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * Created by nickstanogias on 16/11/18.
 */
@Data
public class LoginRequest {
    @NotBlank
    private String email;

    @NotBlank
    private String password;
}
