package com.example.android1.Model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ApiResponse {

    //region Gson Data
    @SerializedName("info")
    @Expose
    private ResponseInfo info;
    @SerializedName("results")
    @Expose
    private List<RickMortyCharacter> results = null;
    //endregion

    //region Getter et Setter
    public ResponseInfo getInfo() {
        return info;
    }

    public void setInfo(ResponseInfo info) {
        this.info = info;
    }

    public List<RickMortyCharacter> getResults() {
        return results;
    }

    public void setResults(List<RickMortyCharacter> results) {
        this.results = results;
    }
    //endregion
    
}
