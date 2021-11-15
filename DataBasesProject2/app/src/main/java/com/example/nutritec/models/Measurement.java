package com.example.nutritec.models;

public class Measurement {

    private String date;
    private String patientEmail;
    private float height;
    private float weight;
    private float hips;
    private float waist;
    private float neck;
    private float fatPercentage;
    private float musclePercentage;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPatientEmail() {
        return patientEmail;
    }

    public void setPatientEmail(String patientEmail) {
        this.patientEmail = patientEmail;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public float getHips() {
        return hips;
    }

    public void setHips(float hips) {
        this.hips = hips;
    }

    public float getWaist() {
        return waist;
    }

    public void setWaist(float waist) {
        this.waist = waist;
    }

    public float getNeck() {
        return neck;
    }

    public void setNeck(float neck) {
        this.neck = neck;
    }

    public float getFatPercentage() {
        return fatPercentage;
    }

    public void setFatPercentage(float fatPercentage) {
        this.fatPercentage = fatPercentage;
    }

    public float getMusclePercentage() {
        return musclePercentage;
    }

    public void setMusclePercentage(float musclePercentage) {
        this.musclePercentage = musclePercentage;
    }
}
