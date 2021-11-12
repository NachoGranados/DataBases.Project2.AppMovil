package com.example.nutritec.interfaces;

import com.example.nutritec.models.Patient;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface PatientRestAPI {

    /*
      PA.1
      Description: Get a single patient based on its email or username
      Url: /api/Patient/login/{credential}
           where credential is the email or username
    */
    @GET("/api/Patient/login/{credential}")
    public Call<Patient> PA1(@Path("credential") String credential);

    /*
      PA.2
      Description: Post a new patient
      Url: /api/Patient
    */
    @POST("/api/Patient")
    public Call<Void> PA2(@Body Patient patient);

}
