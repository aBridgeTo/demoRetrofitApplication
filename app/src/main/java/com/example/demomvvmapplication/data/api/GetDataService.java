package com.example.demomvvmapplication.data.api;

import androidx.lifecycle.LiveData;

import com.example.demomvvmapplication.data.pojo.UserDetail;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetDataService {

    @GET("/users")
    Call<List<UserDetail>> getAllUserDetails();





}
