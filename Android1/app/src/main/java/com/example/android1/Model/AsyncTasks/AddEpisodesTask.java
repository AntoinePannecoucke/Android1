package com.example.android1.Model.AsyncTasks;

import android.os.AsyncTask;

import com.example.android1.Model.ApiResponse;
import com.example.android1.Model.Database.RickMortyDao;
import com.example.android1.Model.Episodes.ApiResponseEpisode;
import com.example.android1.Model.Locations.ApiResponseLocation;

public class AddEpisodesTask extends AsyncTask<Object, Void, Void> {

    private DatabaseCallback callback;

    /**
     * @param[0] => Callback
     * @param[1] => ApiResponseCharacters
     * @param[2] => rickMortyDao
     * @return
     */
    @Override
    protected Void doInBackground(Object... objects) {
        callback = (DatabaseCallback) objects[0];
        ApiResponseEpisode responseCharacters = (ApiResponseEpisode) objects[1];
        RickMortyDao rickMortyDao = (RickMortyDao) objects[2];

        rickMortyDao.addAllEpisodes(responseCharacters.getResults());

        return null;
    }

    protected void onPostExecute(){
        callback.onResponse();
    }
}
