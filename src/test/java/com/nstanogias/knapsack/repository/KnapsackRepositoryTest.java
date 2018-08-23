package com.nstanogias.knapsack.repository;

import com.nstanogias.knapsack.model.Knapsack;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@DataJpaTest
public class KnapsackRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private KnapsackRepository knapsackRepository;

    @Test
    public void whenKnapsackIsPersistedThenKnapsackIsPresent() {
        // given
        Knapsack knapsack = new Knapsack();
        entityManager.persist(knapsack);
        entityManager.flush();

        // when
        Optional<Knapsack> found = knapsackRepository.findById(1L);

        // then
        assertTrue(found.isPresent());
    }
}
