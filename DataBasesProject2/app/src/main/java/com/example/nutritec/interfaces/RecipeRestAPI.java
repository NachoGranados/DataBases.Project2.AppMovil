package com.example.nutritec.interfaces;

import com.example.nutritec.models.Product;
import com.example.nutritec.models.Recipe;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface RecipeRestAPI {

    /*
      RE.1
      Description: Get all the recipes done by a patient
      Url: /api/Recipe/getbypatient/{patientEmail}
           where patientEmail is the logged patient
    */
    @GET("/api/Recipe/getbypatient/{patientEmail}")
    public Call<List<Recipe>> RE1(@Path("patientEmail") String patientEmail);

    /*
      RE.3
      Description: Post a recipe
      Url: /api/Recipe/postrecipe/{name}/{patientEmail}
           where patientEmail is the logged patient, name is the name of the recipe to add
    */
    @POST("/api/Recipe/postrecipe/{name}/{patientEmail}")
    public Call<Recipe> RE3(@Path("name") String name,
                            @Path("patientEmail") String patientEmail);

    /*
      RE.4
      Description: Get all the products in a recipe
      Url: /api/Recipe/getproductsin/{number}
           where number is the number of the recipe
    */
    @GET("/api/Recipe/getproductsin/{number}")
    public Call<List<Recipe>> RE4(@Path("number") int number);

    /*
      RE.5
      Description: Get all the products that are not in a specific recipe
      Url: /api/Recipe/getproductsnotin/{number}
           where number is the number of the recipe
    */
    @GET("/api/Recipe/getproductsnotin/{number}")
    public Call<List<Recipe>> RE5(@Path("number") int number);

    /*
      RE.6
      Description: Add a product in a recipe
      Url: /api/Recipe/newproductinrecipe/{number}/{barcode}/{servings}
           is the logged patient, name is the name of the recipe to add, barcode is the barcode
           of the product and servings is the amount of times the product is in the recipe
    */
    @POST("/api/Recipe/newproductinrecipe/{number}/{barcode}/{servings}")
    public Call<Recipe> RE6(@Path("number") int number,
                            @Path("barcode") int barcode,
                            @Path("servings") int servings);

    /*
      RE.7
      Description: Gets the recipes that have not been consumed by the patient
      Url: /api/Recipe/noconsumption/{patientEmail}/{day}/{meal}
           where patientEmail is the email of the patient that consumed the product, day and meal
           correspond to the time of consumption
    */
    @GET("/api/Recipe/noconsumption/{patientEmail}/{day}/{meal}")
    public Call<List<Product>> RE7(@Path("patientEmail") String patientEmail,
                                   @Path("day") String day,
                                   @Path("meal") String meal);

}
