package com.example.android1.Model.Episodes;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.List;

import com.example.android1.Model.RickMortyData;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Entity
public class RickMortyEpisode extends RickMortyData {

    //region Gson Data
    @SerializedName("id")
    @PrimaryKey
    @Expose
    private Integer id;

    @SerializedName("name")
    @ColumnInfo(name = "name")
    @Expose
    private String name;

    @SerializedName("air_date")
    @ColumnInfo(name = "air_date")
    @Expose
    private String airDate;

    @SerializedName("episode")
    @ColumnInfo(name = "episode")
    @Expose
    private String episode;

    @SerializedName("characters")
    @ColumnInfo(name = "characters")
    @Expose
    private List<String> characters = null;

    @SerializedName("url")
    @ColumnInfo(name = "url")
    @Expose
    private String url;

    @SerializedName("created")
    @ColumnInfo(name = "created")
    @Expose
    private String created;

    //endregion

    //region Getter et Setter
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

    public String getAirDate() {
        return airDate;
    }

    public void setAirDate(String airDate) {
        this.airDate = airDate;
    }

    public String getEpisode() {
        return episode;
    }

    public void setEpisode(String episode) {
        this.episode = episode;
    }

    public List<String> getCharacters() {
        return characters;
    }

    public void setCharacters(List<String> characters) {
        this.characters = characters;
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


    //endregion

}

