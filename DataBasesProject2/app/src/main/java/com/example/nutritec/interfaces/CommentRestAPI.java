package com.example.nutritec.interfaces;

import com.example.nutritec.models.Comment;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface CommentRestAPI {

    /*
      CO.2
      Description: Get all comments filtered by patient, day and meal
      Url: /api/Comment/getcomments/{patientEmail}/{day}/{meal}
           where patientEmail stands for the email of the patient that receives the comment
           (the owner of the consumption data) and day and meal specify the place where the
           comment was done
    */
    @GET("/api/Comment/getcomments/{patientEmail}/{day}/{meal}")
    public Call<List<Comment>> CO2(@Path("patientEmail") String patientEmail,
                                   @Path("day") String day,
                                   @Path("meal") String meal);

    /*
      CO.3
      Description: Post a comment
      Url: /api/Comment/postcomment
    */
    @POST("/api/Comment/postcomment")
    public Call<Comment> CO3(@Body Comment comment);

}
