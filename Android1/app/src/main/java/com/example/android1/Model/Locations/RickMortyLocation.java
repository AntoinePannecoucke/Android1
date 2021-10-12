package com.example.android1.Model.Locations;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.List;

import com.example.android1.Model.RickMortyData;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Entity
public class RickMortyLocation extends RickMortyData {

    @SerializedName("id")
    @PrimaryKey
    @Expose
    private Integer id;

    @SerializedName("name")
    @ColumnInfo(name = "name")
    @Expose
    private String name;

    @SerializedName("type")
    @ColumnInfo(name = "type")
    @Expose
    private String type;

    @SerializedName("dimension")
    @ColumnInfo(name = "dimension")
    @Expose
    private String dimension;

    @SerializedName("residents")
    @ColumnInfo(name = "residents")
    @Expose
    private List<String> residents = null;

    @SerializedName("url")
    @ColumnInfo(name = "url")
    @Expose
    private String url;

    @SerializedName("created")
    @ColumnInfo(name = "created")
    @Expose
    private String created;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDimension() {
        return dimension;
    }

    public void setDimension(String dimension) {
        this.dimension = dimension;
    }

    public List<String> getResidents() {
        return residents;
    }

    public void setResidents(List<String> residents) {
        this.residents = residents;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }


    public String getKey() {
        return this.getClass().getSimpleName() + " " + name;
    }
}

