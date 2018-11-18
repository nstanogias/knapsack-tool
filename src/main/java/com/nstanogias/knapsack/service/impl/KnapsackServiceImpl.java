package com.nstanogias.knapsack.service.impl;

import com.nstanogias.knapsack.event.SolveKnapsackEvent;
import com.nstanogias.knapsack.model.Knapsack;
import com.nstanogias.knapsack.repository.KnapsackRepository;
import com.nstanogias.knapsack.service.KnapsackService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class KnapsackServiceImpl implements KnapsackService {

    @Autowired
    private KnapsackRepository knapsackRepository;

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    @Override
    public Optional<Knapsack> getKnapsack(Integer task) {
        return knapsackRepository.findByTaskId(task);
    }

    @Override
    public Knapsack storeKnapsack(Knapsack knapsack) {
        Knapsack savedKnapsack = knapsackRepository.save(knapsack);
        applicationEventPublisher.publishEvent(new SolveKnapsackEvent(this, savedKnapsack));
        return savedKnapsack;
    }

    @Override
    public Iterable<Knapsack> getAllTasks() {
        return knapsackRepository.findAll();
    }

    @Override
    public void updateKnapsack(Knapsack knapsack) {
        log.info("update Knapsack");
        knapsackRepository.save(knapsack);
    }
}
