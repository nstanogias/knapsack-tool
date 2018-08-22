package com.nstanogias.knapsack.service.impl;

import com.nstanogias.knapsack.event.SolveKnapsackEvent;
import com.nstanogias.knapsack.model.Knapsack;
import com.nstanogias.knapsack.repository.KnapsackRepository;
import com.nstanogias.knapsack.service.KnapsackService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class KnapsackServiceImpl implements KnapsackService {

    private static final Logger LOGGER = LoggerFactory.getLogger(KnapsackServiceImpl.class);

    @Autowired
    private KnapsackRepository knapsackRepository;

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    @Override
    public Optional<Knapsack> getKnapsack(Long task) {
        return knapsackRepository.findById(task);
    }

    @Override
    public Knapsack storeKnapsack(Knapsack knapsack) {
        knapsack = knapsackRepository.save(knapsack);
        applicationEventPublisher.publishEvent(new SolveKnapsackEvent(this, knapsack));
        return knapsack;
    }

    @Override
    public Iterable<Knapsack> getAllTasks() {
        return knapsackRepository.findAll();
    }

    @Override
    public void updateKnapsack(Knapsack knapsack) {
        knapsackRepository.save(knapsack);
    }
}
