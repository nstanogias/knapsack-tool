package com.nstanogias.knapsack.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Problem {

    private int capacity;

    private int[] weights;

    private int[] values;
}
