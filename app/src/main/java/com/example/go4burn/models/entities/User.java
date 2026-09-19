package com.example.go4burn.models.entities;

import java.time.LocalDate;;

public class User {
    private int id;
    private String email;
    private String passwordHash;
    private String fullName;
    private String avatarUrl;
    private String gender;
    private String birthDate;
    private double height;
    private double weight;
    private int dailyStepGoal;
    private String createAt;

    public User(int id, String email, String passwordHash, String fullName, String avatarUrl, String gender, String birthDate, double height, double weight, int dailyStepGoal, String createAt) {
        this.id = id;
        this.email = email;
        this.passwordHash = passwordHash;
        this.fullName = fullName;
        this.avatarUrl = avatarUrl;
        this.gender = gender;
        this.birthDate = birthDate;
        this.height = height;
        this.weight = weight;
        this.dailyStepGoal = dailyStepGoal;
        this.createAt = createAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getDailyStepGoal() {
        return dailyStepGoal;
    }

    public void setDailyStepGoal(int dailyStepGoal) {
        this.dailyStepGoal = dailyStepGoal;
    }

    public String getCreateAt() {
        return createAt;
    }

    public void setCreateAt(String createAt) {
        this.createAt = createAt;
    }

    public int calculateAge() {
        // dd/mm/yyyy
        String birthYearString = getBirthDate().substring(getBirthDate().length() - 4);
        int birthYearInt = Integer.parseInt(birthYearString);
        int currentYear = LocalDate.now().getYear();
        return currentYear - birthYearInt;
    }

    public double calculateBMI() {
        return weight / (height * height);
    }
}
