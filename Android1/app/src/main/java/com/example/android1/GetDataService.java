package com.example.android1;

import com.example.android1.Model.ApiResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GetDataService {
    //region GET Characters
    @GET("/api/character/")
    Call<ApiResponse> getAllCharacters(
    @Query("page") int page);
    //endregion
}