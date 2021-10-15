package com.example.android1.Model.AsyncTasks;

import android.os.AsyncTask;

import com.example.android1.Model.Characters.RickMortyCharacter;
import com.example.android1.Model.Database.RickMortyDao;
import com.example.android1.Model.Locations.RickMortyLocation;

import java.util.List;

public class GetLocationsTask extends AsyncTask<Object, Void, List<RickMortyLocation>> {

    private DatabaseCallback callback;

    @Override
    protected List<RickMortyLocation> doInBackground(Object... objects) {
        callback = (DatabaseCallback) objects[0];
        RickMortyDao rickMortyDao= (RickMortyDao) objects[1];

        return rickMortyDao.getLocations();
    }


    protected void onPostExecute(List<RickMortyLocation> locations) {
        callback.onResponse(locations);
    }
}
