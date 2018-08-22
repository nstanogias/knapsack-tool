package com.nstanogias.knapsack.utils;

public enum Status {
    SUBMITTED("submitted"),
    STARTED("started"),
    COMPLETED("completed");

    String value;

    Status(String status) {
        this.value = status;
    }

    public String getValue() {
        return value;
    }
}
