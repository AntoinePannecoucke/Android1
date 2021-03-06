package com.example.android1;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitRickMorty {
    private static Retrofit retrofit;

    /**
     * Base URL for retrofit requests
     */
    private static final String BASE_URL = "https://rickandmortyapi.com/api/";

    public static Retrofit getRetrofitInstance() {
        if (retrofit == null) {
            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
