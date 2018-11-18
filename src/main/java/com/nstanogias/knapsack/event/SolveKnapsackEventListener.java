package com.nstanogias.knapsack.event;

import com.nstanogias.knapsack.model.Knapsack;
import com.nstanogias.knapsack.model.Solution;
import com.nstanogias.knapsack.service.KnapsackService;
import com.nstanogias.knapsack.utils.Status;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
@Slf4j
public class SolveKnapsackEventListener implements ApplicationListener<SolveKnapsackEvent> {

    @Autowired
    private KnapsackService knapsackService;

    @Override
    @Async
    public void onApplicationEvent(SolveKnapsackEvent solveKnapsackEvent) {
        log.info("Received knapsack event with task id {}", solveKnapsackEvent.getKnapsack().getTaskId());
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long start = System.currentTimeMillis();
        solveKnapsackEvent.getKnapsack().getTimestamps().setStarted(start / 1000L);
        solveKnapsackEvent.getKnapsack().setStatus(Status.STARTED.getValue());
        knapsackService.updateKnapsack(solveKnapsackEvent.getKnapsack());
        List<Integer> items = solveKnapsack(solveKnapsackEvent.getKnapsack().getProblem().getValues(), solveKnapsackEvent.getKnapsack().getProblem().getWeights(), solveKnapsackEvent.getKnapsack().getProblem().getCapacity());
        long finish = System.currentTimeMillis();
        solveKnapsackEvent.getKnapsack().getTimestamps().setCompleted(finish / 1000L);
        solveKnapsackEvent.getKnapsack().setStatus(Status.COMPLETED.getValue());
        long timeTaken = finish - start;
        log.info("Time taken for knapsack with taskId {} in millis is {}", solveKnapsackEvent.getKnapsack().getTaskId(), timeTaken);
        Solution solution = new Solution(items,timeTaken);
        Knapsack knapsack = solveKnapsackEvent.getKnapsack();
        knapsack.setSolution(solution);
        knapsackService.updateKnapsack(knapsack);
    }

    //solution from https://github.com/phishman3579/java-algorithms-implementation/blob/master/src/com/jwetherell/algorithms/mathematics/Knapsack.java
    private List<Integer> solveKnapsack(int[] values, int[] weights, int capacity) {
        log.info("Executing asynchronously by thread " + Thread.currentThread().getName());
        if (weights.length != values.length)
            return null;

        int height = weights.length + 1; // weights==values
        int width = capacity + 1;
        int[][] output = new int[height][width];
        for (int i = 1; i < height; i++) {
            int index = i - 1;
            for (int j = 1; j < width; j++) {
                if (i == 0 || j == 0) {
                    output[i][j] = 0;
                } else {
                    if (weights[index] > j) {
                        output[i][j] = output[i - 1][j];
                    } else {
                        int v = values[index] + output[i - 1][j - weights[index]];
                        output[i][j] = Math.max(output[i - 1][j], v);
                    }
                }
            }
        }

        final List<Integer> list = new ArrayList<>();
        int i = height - 1;
        int j = width - 1;
        while (i != 0 && j != 0) {
            int current = output[i][j];
            int above = output[i - 1][j];
            if (current == above) {
                i -= 1;
            } else {
                i -= 1;
                j -= weights[i];
                list.add(i);
            }
        }
        Collections.sort(list);
        return list;
    }
}
