package com.example.android1.Model.Database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.android1.Model.Characters.RickMortyCharacter;
import com.example.android1.Model.Episodes.RickMortyEpisode;
import com.example.android1.Model.Locations.RickMortyLocation;

import java.util.List;

@Dao
public interface RickMortyDao {

    //region Characters

    @Query("SELECT * FROM rickmortycharacter ")
    List<RickMortyCharacter> getCharacters();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void addAllCharacters(List<RickMortyCharacter> characters);

    //endregion

    //region Episodes

    @Query("SELECT * FROM rickmortyepisode")
    List<RickMortyEpisode> getEpisodes();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void addAllEpisodes(List<RickMortyEpisode> episodes);

    //endregion

    //region Locations

    @Query("SELECT * FROM rickmortylocation")
    List<RickMortyLocation> getLocations();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void addAllLocations(List<RickMortyLocation> locations);

    //endregion
}
