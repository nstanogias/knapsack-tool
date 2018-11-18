package com.nstanogias.knapsack.model;

import com.nstanogias.knapsack.utils.Status;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

@Document(collection = "knapsack")
@Data
public class Knapsack {

    @Id
    private String id;

    private Integer taskId;

    private Problem problem;

    private Solution solution;

    private Timestamps timestamps;

    private String status;

    public Knapsack() {
        this.timestamps = new Timestamps();
        this.status = Status.SUBMITTED.getValue();
    }
}
