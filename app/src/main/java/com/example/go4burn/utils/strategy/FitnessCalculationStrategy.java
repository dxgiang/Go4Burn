package com.example.go4burn.utils.strategy;

public interface FitnessCalculationStrategy {
    public double calculateDistanceKm(int steps, double heightCm);
    public double calculateCalories(int steps, double weightKg, double heightCm);
    public int calculateScore(int steps, int goalSteps);
}
