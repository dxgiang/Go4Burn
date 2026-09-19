package com.example.go4burn.models.entities;

public class DailyActivity {
    private int id;
    private int userId;
    private String date;
    private int step;
    private double calories;
    private int activeMinutes;
    private double distanceKm;
    private int score;
    private String status;
    private boolean isGoalAchieved;

    public DailyActivity(int id, int userId, String date, int step, double calories, int activeMinutes, double distanceKm, int score, String status, boolean isGoalAchieved) {
        this.id = id;
        this.userId = userId;
        this.date = date;
        this.step = step;
        this.calories = calories;
        this.activeMinutes = activeMinutes;
        this.distanceKm = distanceKm;
        this.score = score;
        this.status = status;
        this.isGoalAchieved = isGoalAchieved;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getStep() {
        return step;
    }

    public void setStep(int step) {
        this.step = step;
    }

    public double getCalories() {
        return calories;
    }

    public void setCalories(double calories) {
        this.calories = calories;
    }

    public int getActiveMinutes() {
        return activeMinutes;
    }

    public void setActiveMinutes(int activeMinutes) {
        this.activeMinutes = activeMinutes;
    }

    public double getDistanceKm() {
        return distanceKm;
    }

    public void setDistanceKm(double distanceKm) {
        this.distanceKm = distanceKm;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isGoalAchieved() {
        return isGoalAchieved;
    }

    public void setGoalAchieved(boolean goalAchieved) {
        isGoalAchieved = goalAchieved;
    }
}
