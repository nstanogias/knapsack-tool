package com.nstanogias.knapsack.model;

import lombok.Data;
import java.util.List;

@Data
public class Solution {

    private List<Integer> items;

    private long time;

    public Solution() {

    }

    public Solution(List<Integer> items, long time) {
        this.items = items;
        this.time = time;
    }
}
