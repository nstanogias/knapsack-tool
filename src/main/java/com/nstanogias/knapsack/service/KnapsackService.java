package com.nstanogias.knapsack.service;


import com.nstanogias.knapsack.model.Knapsack;

import java.util.Optional;

public interface KnapsackService {

    Optional<Knapsack> getKnapsack(Long task);

    Knapsack storeKnapsack(Knapsack knapsack);

    Iterable<Knapsack> getAllTasks();

    void updateKnapsack(Knapsack knapsack);
}
