package com.nstanogias.knapsack.controller;

import com.nstanogias.knapsack.model.*;
import com.nstanogias.knapsack.service.KnapsackService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/knapsack")
public class KnapsackController implements ApplicationContextAware{

    private static final Logger LOGGER = LoggerFactory.getLogger(KnapsackController.class);
    private ApplicationContext context;

    @Autowired
    private KnapsackService knapsackService;


    @PostMapping(value = "/tasks", consumes = "application/json", produces = "application/json")
    public Task createKnapsackProblem(@RequestBody Problem problem) {
        LOGGER.info("Creating a new knapsack problem...");

        Knapsack knapsack = new Knapsack();
        knapsack.setProblem(problem);
        knapsack = knapsackService.storeKnapsack(knapsack);
        LOGGER.info("Created knapsack problem with task id {}", knapsack.getTask());
        return new Task(knapsack.getTask(),knapsack.getTimestamps(),knapsack.getStatus());
    }

    @GetMapping("/tasks/{task}")
    public ResponseEntity<Task> getKnapsackStatus(@PathVariable Long task) {
        LOGGER.info("Get status of task id {}", task);

        Optional<Knapsack> knapsackData = knapsackService.getKnapsack(task);
        if (knapsackData.isPresent()) {
            return new ResponseEntity<>(new Task(knapsackData.get().getTask(),
                    knapsackData.get().getTimestamps(),
                    knapsackData.get().getStatus()),
                    HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/solutions/{task}")
    public ResponseEntity<SolutionResponse> getKnapsackSolution(@PathVariable Long task) {
        LOGGER.info("Get solution of task id {}", task);

        Optional<Knapsack> knapsackData = knapsackService.getKnapsack(task);
        if (knapsackData.isPresent()) {
            return new ResponseEntity<>(new SolutionResponse(knapsackData.get().getTask(),
                    knapsackData.get().getProblem(),
                    knapsackData.get().getSolution()),
                    HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/admin/tasks")
    public List<Task> getAllTasks() {
        LOGGER.info("Get all Tasks...");

        List<Task> list = new ArrayList<>();
        Iterable<Knapsack> knapsacks = knapsackService.getAllTasks();

        knapsacks.forEach(knapsack -> {
            list.add(new Task(knapsack.getTask(), knapsack.getTimestamps(), knapsack.getStatus()));
        });
        return list;
    }

    @PostMapping("/admin/shutdown")
    public void shutDownService() {
        LOGGER.info("Service shutting down...");
        ((ConfigurableApplicationContext) context).close();
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }
}
