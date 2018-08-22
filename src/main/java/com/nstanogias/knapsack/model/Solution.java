package com.nstanogias.knapsack.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Solution {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long task;
    @ElementCollection(targetClass=Integer.class)
    private List<Integer> items;
    private long time;

    public Solution() {

    }

    public Solution(List<Integer> items, long time) {
        this.items = items;
        this.time = time;
    }

    public List<Integer> getItems() {
        return items;
    }

    public void setItems(List<Integer> items) {
        this.items = items;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }
}
