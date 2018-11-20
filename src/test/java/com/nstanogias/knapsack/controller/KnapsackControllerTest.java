package com.nstanogias.knapsack.controller;

import com.nstanogias.knapsack.model.Knapsack;
import com.nstanogias.knapsack.model.Timestamps;
import com.nstanogias.knapsack.repository.UserRepository;
import com.nstanogias.knapsack.service.KnapsackService;
import com.nstanogias.knapsack.service.NextSequenceService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(KnapsackController.class)
public class KnapsackControllerTest {
    @Autowired
    private MockMvc mvc;

    @MockBean
    private KnapsackService service;

    @MockBean
    private UserRepository userRepository;

    @MockBean
    private NextSequenceService nextSequenceService;

    @Test
    @WithMockUser(username = "admin", password = "admin", roles = "ADMIN")
    public void givenKnapsacks_whenGetTasks_thenReturnJsonArray() throws Exception {

        Knapsack knapsack = new Knapsack();
        knapsack.setTaskId(1);
        knapsack.setTimestamps(new Timestamps());

        Iterable<Knapsack> allKnapsacks = Arrays.asList(knapsack);

        given(service.getAllTasks()).willReturn(allKnapsacks);

        mvc.perform(get("/api/knapsack/admin/tasks")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)));
    }
}
