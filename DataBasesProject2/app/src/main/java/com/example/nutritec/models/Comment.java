package com.example.nutritec.models;

public class Comment {

    private String patientEmail;
    private String day;
    private String meal;
    private String commentOwnerEmail;
    private String commentText;

    public String getPatientEmail() {
        return patientEmail;
    }

    public void setPatientEmail(String patientEmail) {
        this.patientEmail = patientEmail;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getMeal() {
        return meal;
    }

    public void setMeal(String meal) {
        this.meal = meal;
    }

    public String getCommentOwnerEmail() {
        return commentOwnerEmail;
    }

    public void setCommentOwnerEmail(String commentOwnerEmail) {
        this.commentOwnerEmail = commentOwnerEmail;
    }

    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }

}
