package com.example.android1.Model.Episodes;

import com.example.android1.Model.ApiResponse;
import com.example.android1.Model.ResponseInfo;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ApiResponseEpisode extends ApiResponse {

    //region Gson Data

    @SerializedName("results")
    @Expose
    private List<RickMortyEpisode> results = null;
    //endregion

    //region Getter et Setter

    public List<RickMortyEpisode> getResults() {
        return results;
    }

    public void setResults(List<RickMortyEpisode> results) {
        this.results = results;
    }
    //endregion
}
