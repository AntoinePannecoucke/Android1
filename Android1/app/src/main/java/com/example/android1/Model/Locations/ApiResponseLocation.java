package com.example.android1.Model.Locations;

import com.example.android1.Model.ApiResponse;
import com.example.android1.Model.Episodes.RickMortyEpisode;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ApiResponseLocation extends ApiResponse {
    //region Gson Data

    @SerializedName("results")
    @Expose
    private List<RickMortyLocation> results = null;
    //endregion

    //region Getter et Setter

    public List<RickMortyLocation> getResults() {
        return results;
    }

    public void setResults(List<RickMortyLocation> results) {
        this.results = results;
    }
    //endregion


}
