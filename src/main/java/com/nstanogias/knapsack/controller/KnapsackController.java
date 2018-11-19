package com.nstanogias.knapsack.controller;

import com.nstanogias.knapsack.model.*;
import com.nstanogias.knapsack.repository.UserRepository;
import com.nstanogias.knapsack.service.KnapsackService;
import com.nstanogias.knapsack.service.NextSequenceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/knapsack")
public class KnapsackController implements ApplicationContextAware{

    private static final Logger LOGGER = LoggerFactory.getLogger(KnapsackController.class);
    private ApplicationContext context;

    @Autowired
    private KnapsackService knapsackService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private NextSequenceService nextSequenceService;


    @PostMapping(value = "/tasks", consumes = "application/json", produces = "application/json")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public Task createKnapsackProblem(@RequestBody Problem problem) {
        LOGGER.info("Creating a new knapsack problem...");

        Knapsack knapsack = new Knapsack();
        knapsack.setProblem(problem);
        knapsack.setTaskId(nextSequenceService.getNextSequence("customSequences"));
        knapsack = knapsackService.storeKnapsack(knapsack);
        LOGGER.info("Created knapsack problem with task id {}", knapsack.getTaskId());
        return new Task(knapsack.getTaskId(),knapsack.getTimestamps(),knapsack.getStatus());
    }

    @GetMapping("/tasks/{task}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<Task> getKnapsackStatus(@PathVariable Integer task) {
        LOGGER.info("Get status of task id {}", task);

        Optional<Knapsack> knapsackData = knapsackService.getKnapsack(task);
        if (knapsackData.isPresent()) {
            return new ResponseEntity<>(new Task(knapsackData.get().getTaskId(),
                    knapsackData.get().getTimestamps(),
                    knapsackData.get().getStatus()),
                    HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/solutions/{task}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<SolutionResponse> getKnapsackSolution(@PathVariable Integer task) {
        LOGGER.info("Get solution of task id {}", task);

        Optional<Knapsack> knapsackData = knapsackService.getKnapsack(task);
        if (knapsackData.isPresent()) {
            return new ResponseEntity<>(new SolutionResponse(knapsackData.get().getTaskId(),
                    knapsackData.get().getProblem(),
                    knapsackData.get().getSolution()),
                    HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/admin/tasks")
    @PreAuthorize("hasRole('ADMIN')")
    public List<Knapsack> getAllTasks() {
        LOGGER.info("Get all Tasks...");

        List<Knapsack> list = new ArrayList<>();
        Iterable<Knapsack> knapsacks = knapsackService.getAllTasks();

        knapsacks.forEach(knapsack -> {
            list.add(knapsack);
        });
        return list;
    }

    @PostMapping("/admin/shutdown")
    @PreAuthorize("hasRole('ADMIN')")
    public void shutDownService() {
        LOGGER.info("Service shutting down...");
        ((ConfigurableApplicationContext) context).close();
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }
}
