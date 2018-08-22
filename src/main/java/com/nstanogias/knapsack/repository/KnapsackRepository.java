package com.nstanogias.knapsack.repository;

import com.nstanogias.knapsack.model.Knapsack;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KnapsackRepository extends CrudRepository<Knapsack, Long>{
}
