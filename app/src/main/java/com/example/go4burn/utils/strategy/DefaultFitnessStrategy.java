package com.example.go4burn.utils.strategy;

public class DefaultFitnessStrategy implements FitnessCalculationStrategy{
    @Override
    public double calculateDistanceKm(int steps, double heightCm) {
        return (steps * (heightCm * 0.414)) / 100000;
    }

    @Override
    public double calculateCalories(int steps, double weightKg, double heightCm) {
        return 0;
    }

    @Override
    public int calculateScore(int steps, int goalSteps) {
        double phanTram = ((double) steps/goalSteps)*100;
        long lamTron = Math.round(phanTram);
        return (int) Math.min(110, lamTron);
    }
}
