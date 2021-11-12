package com.example.nutritec.interfaces;

import com.example.nutritec.models.Product;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ProductRestAPI {

    /*
      PR.8
      Description: Get the products and recipes the patient consumed at a specific day and meal
      Url: /api/Product/consumption/{patientEmail}/{day}/{meal}
           where patientEmail is the chosen patient day and meal filter the products/recipes
    */
    @GET("/api/Product/consumption/{patientEmail}/{day}/{meal}")
    public Call<List<Product>> PR8(@Path("patientEmail") String patientEmail,
                                   @Path("day") String day,
                                   @Path("meal") String meal);

    /*
      PR.9
      Description: Adds a product to the consumption table of a specific patient.
      Url: /api/Product/consumption/addproduct/{barcode}/{patientEmail}/{day}/{meal}/{servings}
           where barcode is the barcode of the product to add, patientEmail is the email of the
           patient that consumed the product, day and meal correspond to the time of consumption
           and servings is the amount of product consumed.
    */
    @GET("/api/Product/consumption/addproduct/{barcode}/{patientEmail}/{day}/{meal}/{servings}")
    public Call<Product> PR9(@Path("barcode") int barcode,
                             @Path("patientEmail") String patientEmail,
                             @Path("day") String day,
                             @Path("meal") String meal,
                             @Path("servings") int servings);

    /*
      PR.10
      Description: Gets the products that have not been consumed by the patient.
      Url: /api/Product/noconsumption/{patientEmail}/{day}/{meal} where patientEmail is the email of the patient that consumed the product, day and meal correspond to the time of consumption
    */
    @GET("/api/Product/noconsumption/{patientEmail}/{day}/{meal}")
    public Call<List<Product>> PR10(@Path("patientEmail") String patientEmail,
                                    @Path("day") String day,
                                    @Path("meal") String meal);

}
