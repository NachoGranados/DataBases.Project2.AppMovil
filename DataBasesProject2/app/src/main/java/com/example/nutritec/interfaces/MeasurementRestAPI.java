package com.example.nutritec.interfaces;

import com.example.nutritec.models.Measurement;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface MeasurementRestAPI {

    /*
      ME.3
      Description: Post a measurement.
      Url: /api/Measurement
    */
    @POST("/api/Measurement")
    public Call<Void> ME3(@Body Measurement measurement);

}
