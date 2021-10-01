package com.example.android1;

import com.example.android1.Model.Characters.ApiResponseCharacters;
import com.example.android1.Model.Episodes.ApiResponseEpisode;
import com.example.android1.Model.Locations.ApiResponseLocation;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GetDataService {
    //region GET Characters
    @GET("character/")
    Call<ApiResponseCharacters> getAllCharacters(
        @Query("page") int page
    );
    //endregion

    //region GET Episodes
    @GET("episode/")
    Call<ApiResponseEpisode> getAllEpisodes(
            @Query("page") int page
    );
    //endregion

    //region GET Locations
    @GET("location/")
    Call<ApiResponseLocation> getAllLocations(
            @Query("page") int page
    );
    //endregion
}