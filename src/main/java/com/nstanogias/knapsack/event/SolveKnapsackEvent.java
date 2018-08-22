package com.nstanogias.knapsack.event;

import com.nstanogias.knapsack.model.Knapsack;
import org.springframework.context.ApplicationEvent;

public class SolveKnapsackEvent extends ApplicationEvent{

    private Knapsack knapsack;

    public SolveKnapsackEvent(Object source, Knapsack knapsack) {
        super(source);
        this.knapsack = knapsack;
    }

    public Knapsack getKnapsack() {
        return knapsack;
    }
}
