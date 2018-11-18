package com.nstanogias.knapsack.model;

import lombok.Data;

@Data
public class Timestamps {

    private Long submitted;
    private Long started;
    private Long completed;

    public Timestamps() {
        this.submitted = System.currentTimeMillis() / 1000L;
        this.started = null;
        this.completed = null;
    }
}
