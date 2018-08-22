package com.nstanogias.knapsack.model;

import com.nstanogias.knapsack.utils.Status;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Knapsack {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long task;

    @OneToOne(cascade = CascadeType.ALL)
    @NotNull
    private Problem problem;

    @OneToOne(cascade = CascadeType.ALL)
    private Solution solution;

    @OneToOne(cascade = CascadeType.ALL)
    private Timestamps timestamps;

    private String status;

    public Knapsack() {
        this.timestamps = new Timestamps();
        this.status = Status.SUBMITTED.getValue();
    }

    public Long getTask() {
        return task;
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

    public Timestamps getTimestamps() {
        return timestamps;
    }

    public void setTimestamps(Timestamps timestamps) {
        this.timestamps = timestamps;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
