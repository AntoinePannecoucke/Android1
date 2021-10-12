package com.example.android1.Model;

public abstract class RickMortyData {
    protected boolean isFavorite;

    public RickMortyData() {
        isFavorite = false;
    }

    public boolean isFavorite() {
        return isFavorite;
    }

    public void setFavorite(boolean favorite) {
        isFavorite = favorite;
    }

    String getKey() { return null; }
    Integer getId() { return null; }
}
