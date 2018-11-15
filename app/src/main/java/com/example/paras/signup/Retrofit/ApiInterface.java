package com.example.paras.signup.Retrofit;

import com.example.paras.signup.RoomDb.User;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiInterface {

    @GET("/api/unknown")
    Call<UserModel> GetUserList();

    @POST("/api/users")
    Call<UserModel> createUser(@Body User user);
}
