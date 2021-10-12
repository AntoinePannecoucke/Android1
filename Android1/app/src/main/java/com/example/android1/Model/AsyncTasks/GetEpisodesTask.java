package com.example.android1.Model.AsyncTasks;

import android.os.AsyncTask;

import com.example.android1.Model.Database.RickMortyDao;
import com.example.android1.Model.Episodes.RickMortyEpisode;
import com.example.android1.Model.Locations.RickMortyLocation;

import java.util.List;

public class GetEpisodesTask extends AsyncTask<Object, Void, List<RickMortyEpisode>> {

    private DatabaseCallback callback;

    @Override
    protected List<RickMortyEpisode> doInBackground(Object... objects) {
        callback = (DatabaseCallback) objects[0];
        RickMortyDao rickMortyDao= (RickMortyDao) objects[1];

        return rickMortyDao.getEpisodes();
    }


    protected void onPostExecute(List<RickMortyEpisode> episodes) {
        callback.onResponse(episodes);
    }
}
