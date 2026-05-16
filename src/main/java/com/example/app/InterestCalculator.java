package com.example.app;

public class InterestCalculator {

    public static double calculateInterest(
            double principal,
            double rate,
            double time
    ) {

        return (principal * rate * time) / 100;
    }
}
