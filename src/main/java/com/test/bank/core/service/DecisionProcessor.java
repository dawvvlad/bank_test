package com.test.bank.core.service;

import java.util.Random;

public class DecisionProcessor {
    private final Random random = new Random();

    public double makeDecision(double amount) {
        double approvedSum = Math.round(random.nextDouble(0, amount));
        if(approvedSum > (amount / 4)) {
            return approvedSum;
        } else {
            return -1;
        }
    }
}
