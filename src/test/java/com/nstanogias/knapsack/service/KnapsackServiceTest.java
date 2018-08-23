package com.nstanogias.knapsack.service;

import com.nstanogias.knapsack.model.Knapsack;
import com.nstanogias.knapsack.repository.KnapsackRepository;
import com.nstanogias.knapsack.service.impl.KnapsackServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
public class KnapsackServiceTest {

    @TestConfiguration
    static class KnapsackServiceImplTestContextConfiguration {

        @Bean
        public KnapsackService knapsackService() {
            return new KnapsackServiceImpl();
        }
    }

    @Autowired
    private KnapsackService knapsackService;

    @MockBean
    private KnapsackRepository knapsackRepository;

    @Before
    public void setUp() {
        Knapsack knapsack = new Knapsack();

        Mockito.when(knapsackRepository.findById(1L)).thenReturn(Optional.ofNullable(knapsack));
    }

    @Test
    public void whenPersistedThenKnapsackShouldBeFound() {
        Long task = 1L;
        Optional<Knapsack> found = knapsackService.getKnapsack(task);

        assertTrue(found.isPresent());
    }
}
