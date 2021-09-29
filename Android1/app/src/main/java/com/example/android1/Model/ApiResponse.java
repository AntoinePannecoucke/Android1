package com.example.android1.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ApiResponse {

    @SerializedName("info")
    @Expose
    protected ResponseInfo info;

    public ResponseInfo getInfo() {
        return info;
    }

    public void setInfo(ResponseInfo info) {
        this.info = info;
    }
}
