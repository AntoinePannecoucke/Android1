package com.example.android1.Model.AsyncTasks;

import android.os.AsyncTask;

import com.example.android1.Model.Characters.RickMortyCharacter;
import com.example.android1.Model.Database.RickMortyDao;

import java.util.List;

public class GetCharactersTask extends AsyncTask<Object, Void, List<RickMortyCharacter>> {

    private DatabaseCallback callback;

    @Override
    protected List<RickMortyCharacter> doInBackground(Object... objects) {
        callback = (DatabaseCallback) objects[0];
        RickMortyDao rickMortyDao= (RickMortyDao) objects[1];

        return rickMortyDao.getCharacters();
    }


    protected void onPostExecute(List<RickMortyCharacter> characters) {
        callback.onResponse(characters);
    }
}
