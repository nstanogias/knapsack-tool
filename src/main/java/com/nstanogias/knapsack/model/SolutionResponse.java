package com.nstanogias.knapsack.model;

import lombok.Data;

@Data
public class SolutionResponse {
    private Integer taskId;
    private Problem problem;
    private Solution solution;

    public SolutionResponse(Integer taskId, Problem problem, Solution solution) {
        this.taskId = taskId;
        this.problem = problem;
        this.solution = solution;
    }
}
