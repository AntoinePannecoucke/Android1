package com.example.android1.Model.Characters;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.List;

import com.example.android1.Model.RickMortyData;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Entity
public class RickMortyCharacter extends RickMortyData {

    //region Gson Data
    @SerializedName("id")
    @PrimaryKey
    @Expose
    private Integer id;

    @SerializedName("name")
    @ColumnInfo(name = "name")
    @Expose
    private String name;

    @SerializedName("status")
    @ColumnInfo(name = "status")
    @Expose
    private String status;

    @SerializedName("species")
    @ColumnInfo(name = "species")
    @Expose
    private String species;

    @SerializedName("type")
    @ColumnInfo(name = "type")
    @Expose
    private String type;

    @SerializedName("gender")
    @ColumnInfo(name = "gender")
    @Expose
    private String gender;

    @SerializedName("origin")
    @ColumnInfo(name = "origin")
    @Expose
    private Origin origin;

    @SerializedName("location")
    @ColumnInfo(name = "location")
    @Expose
    private Location location;

    @SerializedName("image")
    @ColumnInfo(name = "image")
    @Expose
    private String image;

    @SerializedName("episode")
    @ColumnInfo(name = "episode")
    @Expose
    private List<String> episode = null;

    @SerializedName("url")
    @ColumnInfo(name = "url")
    @Expose
    private String url;

    @SerializedName("created")
    @ColumnInfo(name = "created")
    @Expose
    private String created;

    //endregion

    //region Constructors
    public RickMortyCharacter() {

    }

    public RickMortyCharacter(Integer id, String name, String status, String species, String type, String gender, Origin origin, Location location, String image, List<String> episode, String url, String created) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.species = species;
        this.type = type;
        this.gender = gender;
        this.origin = origin;
        this.location = location;
        this.image = image;
        this.episode = episode;
        this.url = url;
        this.created = created;
    }

    //endregion

    //region Getter and Setter

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Origin getOrigin() {
        return origin;
    }

    public void setOrigin(Origin origin) {
        this.origin = origin;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<String> getEpisode() {
        return episode;
    }

    public void setEpisode(List<String> episode) {
        this.episode = episode;
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