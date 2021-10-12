package com.example.android1.Model.Database;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.example.android1.Model.Characters.RickMortyCharacter;
import com.example.android1.Model.Episodes.RickMortyEpisode;
import com.example.android1.Model.Locations.RickMortyLocation;

@Database(entities = {RickMortyCharacter.class, RickMortyLocation.class, RickMortyEpisode.class}, version = 1)
@TypeConverters(Converters.class)
public abstract class AppDatabase extends RoomDatabase {
    public abstract RickMortyDao rickMortyDao();
}
