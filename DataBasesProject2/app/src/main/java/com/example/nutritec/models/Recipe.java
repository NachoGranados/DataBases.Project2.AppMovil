package com.example.nutritec.models;

import java.util.List;

public class Recipe {

    private int number;
    private String name;
    private String patientEmail;
    private String patientEmailNavigation;
    private List<String> consumesRecipes;
    private List<String> recipeHas;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatientEmail() {
        return patientEmail;
    }

    public void setPatientEmail(String patientEmail) {
        this.patientEmail = patientEmail;
    }

    public String getPatientEmailNavigation() {
        return patientEmailNavigation;
    }

    public void setPatientEmailNavigation(String patientEmailNavigation) {
        this.patientEmailNavigation = patientEmailNavigation;
    }

    public List<String> getConsumesRecipes() {
        return consumesRecipes;
    }

    public void setConsumesRecipes(List<String> consumesRecipes) {
        this.consumesRecipes = consumesRecipes;
    }

    public List<String> getRecipeHas() {
        return recipeHas;
    }

    public void setRecipeHas(List<String> recipeHas) {
        this.recipeHas = recipeHas;
    }
}
