package com.example.android1.Model.Database;

import androidx.room.TypeConverter;

import com.example.android1.Model.Characters.Location;
import com.example.android1.Model.Characters.Origin;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;

public class Converters {

    @TypeConverter
    public static List<String> restoreList(String listOfString) {
        return new Gson().fromJson(listOfString, new TypeToken<List<String>>() {}.getType());
    }

    @TypeConverter
    public static String saveList(List<String> listOfString) {
        return new Gson().toJson(listOfString);
    }

    @TypeConverter
    public static Location restoreLocation(String location) {
        return new Gson().fromJson(location, new TypeToken<Location>() {}.getType());
    }

    @TypeConverter
    public static String saveLocation(Location location) {
        return new Gson().toJson(location);
    }

    @TypeConverter
    public static Origin restoreOrigin(String origin) {
        return new Gson().fromJson(origin, new TypeToken<Origin>() {}.getType());
    }

    @TypeConverter
    public static String saveOrigin(Origin origin) {
        return new Gson().toJson(origin);
    }
}
