package com.example.android1.Model.Characters;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Origin {

    //region Gson Data
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("url")
    @Expose
    private String url;
    //endregion

    //region Getter et Setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    //endregion

}
