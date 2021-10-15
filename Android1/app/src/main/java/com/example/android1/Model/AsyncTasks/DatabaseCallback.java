package com.example.android1.Model.AsyncTasks;

import com.example.android1.MainActivity;
import com.example.android1.Model.Database.RickMortyDao;
import com.example.android1.Model.RickMortyData;

import java.util.List;

import javax.security.auth.callback.Callback;

public class DatabaseCallback implements Callback {

    private MainActivity parent;

    public DatabaseCallback(MainActivity parent) {
        this.parent = parent;
    }

    public void onResponse(){

    }

    public void onResponse(List<?> data){
        parent.onResponse(data);
    }
}
