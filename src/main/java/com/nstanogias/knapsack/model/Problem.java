package com.nstanogias.knapsack.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Problem {

    @NotBlank
    @Positive
    private int capacity;

    @NotBlank
    private int[] weights;

    @NotBlank
    private int[] values;
}
