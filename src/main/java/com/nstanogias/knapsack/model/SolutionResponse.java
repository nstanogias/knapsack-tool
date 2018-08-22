package com.nstanogias.knapsack.model;


public class SolutionResponse {
    private Long task;
    private Problem problem;
    private Solution solution;

    public SolutionResponse(Long task, Problem problem, Solution solution) {
        this.task = task;
        this.problem = problem;
        this.solution = solution;
    }

    public Problem getProblem() {
        return problem;
    }

    public void setProblem(Problem problem) {
        this.problem = problem;
    }

    public Solution getSolution() {
        return solution;
    }

    public void setSolution(Solution solution) {
        this.solution = solution;
    }
}
