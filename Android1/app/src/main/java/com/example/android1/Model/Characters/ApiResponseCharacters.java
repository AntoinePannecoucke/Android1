package com.example.android1.Model.Characters;

import java.util.List;

import com.example.android1.Model.ApiResponse;
import com.example.android1.Model.Characters.RickMortyCharacter;
import com.example.android1.Model.ResponseInfo;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ApiResponseCharacters extends ApiResponse {

    //region Gson Data
    @SerializedName("results")
    @Expose
    private List<RickMortyCharacter> results = null;
    //endregion

    //region Getter et Setter


    public List<RickMortyCharacter> getResults() {
        return results;
    }

    public void setResults(List<RickMortyCharacter> results) {
        this.results = results;
    }
    //endregion
    
}
