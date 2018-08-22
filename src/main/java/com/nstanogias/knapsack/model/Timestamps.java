package com.nstanogias.knapsack.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Timestamps {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long task;
    private Long submitted;
    private Long started;
    private Long completed;

    public Timestamps() {
        this.submitted = System.currentTimeMillis() / 1000L;
        this.started = null;
        this.completed = null;
    }

    public Long getSubmitted() {
        return submitted;
    }

    public void setSubmitted(Long submitted) {
        this.submitted = submitted;
    }

    public Long getStarted() {
        return started;
    }

    public void setStarted(Long started) {
        this.started = started;
    }

    public Long getCompleted() {
        return completed;
    }

    public void setCompleted(Long completed) {
        this.completed = completed;
    }
}
