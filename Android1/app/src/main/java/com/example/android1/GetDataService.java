package com.example.android1;

import com.example.android1.Model.ApiResponse;
import com.example.android1.Model.RickMortyCharacter;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetDataService {

    @GET("/api/character/")
    Call<ApiResponse> getAllCharacters();
}