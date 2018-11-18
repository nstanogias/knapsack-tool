package com.nstanogias.knapsack.repository;

import com.nstanogias.knapsack.model.Knapsack;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class KnapsackRepositoryITTest {

    @Autowired
    private KnapsackRepository knapsackRepository;

    @After
    public void cleanUp() {
        knapsackRepository.deleteByTaskId(1);
    }

    @Test
    public void whenKnapsackIsPersistedThenKnapsackIsPresent() {
        // given
        Knapsack knapsack = new Knapsack();
        knapsack.setTaskId(1);
        knapsackRepository.save(knapsack);

        // when
        Optional<Knapsack> found = knapsackRepository.findByTaskId(1);

        // then
        assertTrue(found.isPresent());
    }
}
