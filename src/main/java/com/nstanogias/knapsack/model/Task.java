package com.nstanogias.knapsack.model;


public class Task {
    private Long taskId;
    private Timestamps timestamps;
    private String status;

    public Task(Long taskId, Timestamps timestamps, String status) {
        this.taskId = taskId;
        this.timestamps = timestamps;
        this.status = status;
    }

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
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
