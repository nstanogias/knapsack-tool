package com.nstanogias.knapsack.model;


import lombok.Data;

@Data
public class Task {
    private Integer taskId;
    private Timestamps timestamps;
    private String status;

    public Task(Integer taskId, Timestamps timestamps, String status) {
        this.taskId = taskId;
        this.timestamps = timestamps;
        this.status = status;
    }
}
