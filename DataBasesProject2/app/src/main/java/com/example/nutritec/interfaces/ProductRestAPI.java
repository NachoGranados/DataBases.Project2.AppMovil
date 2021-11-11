package com.example.nutritec.interfaces;

import com.example.nutritec.models.Product;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ProductRestAPI {

    /*
      PR.1
      Description: get all products based on its approval state
      Url: /api/Product/state/{state} where state is the approval state we want to filter on. The avalable states are Pending, Approved and Declined
    */
    @GET("/api/Product/state/{state}")
    public Call<List<Product>> PR1(@Path("state") String state);

    /*
      PR.8
      Description: Get the products and recipes the patient consumed at a specific day and meal
      Url: /api/Product/consumption/{patientEmail}/{day}/{meal} where patientEmail is the chosen patient day and meal filter the products/recipes
    */
    @GET("/api/Product/consumption/{patientEmail}/{day}/{meal}")
    public Call<List<Product>> PR8(@Path("patientEmail") String patientEmail,
                                   @Path("day") String day,
                                   @Path("meal") String meal);

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
