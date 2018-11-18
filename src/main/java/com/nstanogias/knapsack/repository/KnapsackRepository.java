package com.nstanogias.knapsack.repository;

import com.nstanogias.knapsack.model.Knapsack;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface KnapsackRepository extends MongoRepository<Knapsack, Long> {

    Optional<Knapsack> findByTaskId(Integer taskId);

    void deleteByTaskId(Integer taskId);
}
