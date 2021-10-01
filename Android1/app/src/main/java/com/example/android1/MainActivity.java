package com.example.android1;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.android1.Adapters.CharacterAdapter;
import com.example.android1.Adapters.EpisodeAdapter;
import com.example.android1.Adapters.LocationAdapter;
import com.example.android1.Interface.CustomAdapter;
import com.example.android1.Interface.EndScrollListener;
import com.example.android1.Model.Characters.ApiResponseCharacters;
import com.example.android1.Model.Episodes.ApiResponseEpisode;
import com.example.android1.Model.Locations.ApiResponseLocation;
import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.auth.FirebaseAuthUIActivityResultContract;
import com.firebase.ui.auth.IdpResponse;
import com.firebase.ui.auth.data.model.FirebaseAuthUIAuthenticationResult;
import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements EndScrollListener {

    private NavigationBarView navBar;

    //region Auth
    List<AuthUI.IdpConfig> providers = Arrays.asList(
            new AuthUI.IdpConfig.GoogleBuilder().build(),
            new AuthUI.IdpConfig.EmailBuilder().build());

    Intent signInIntent = AuthUI.getInstance()
            .createSignInIntentBuilder()
            .setAvailableProviders(providers)
            .build();

    private FirebaseAuth mAuth;

    private final ActivityResultLauncher<Intent> signInLauncher = registerForActivityResult(
            new FirebaseAuthUIActivityResultContract(),
            new ActivityResultCallback<FirebaseAuthUIAuthenticationResult>() {
                @Override
                public void onActivityResult(FirebaseAuthUIAuthenticationResult result) {
                    onSignInResult(result);
                }
            }
    );

    /**
     * Result on the SignIn
     * @param result
     */
    private void onSignInResult(FirebaseAuthUIAuthenticationResult result) {
        IdpResponse response = result.getIdpResponse();
        if (result.getResultCode() == RESULT_OK) {
            // Successfully signed in
            FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
            // ...
        } else {
            // Sign in failed. If response is null the user canceled the
            // sign-in flow using the back button. Otherwise check
            // response.getError().getErrorCode() and handle the error.
            // ...
        }
    }
    //endregion

    //region App Life
    /**
     * onCreate
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        InitNav();
        initRecyclerView();
        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();
        signInLauncher.launch(signInIntent);

        progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog.setMessage("Loading....");
        progressDialog.show();

        /*Create handle for the RetrofitInstance interface*/
        current_page = 1;
        getCharacterAt(current_page);

    }

    /**
     * onStart
     */
    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            currentUser.reload();
        }
    }

    /**
     * onStop
     */
    @Override
    protected void onStop() {
        super.onStop();
        FirebaseAuth.getInstance().signOut();
    }

    //endregion

    //region RecyclerView
    private CharacterAdapter charAdapter;
    private EpisodeAdapter epAdapter;
    private RecyclerView recyclerView;
    private LocationAdapter locAdapter;
    ProgressDialog progressDialog;

    private int current_page;

    private void initRecyclerView(){
        recyclerView = findViewById(R.id.customRecyclerView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);
    }

    /**
     * Load data of a page
     * @param page
     */
    private void getCharacterAt(int page){
        GetDataService service = RetrofitRickMorty.getRetrofitInstance().create(GetDataService.class);
        Call<ApiResponseCharacters> call = service.getAllCharacters(page);
        call.enqueue(new Callback<ApiResponseCharacters>() {
            @Override
            public void onResponse(Call<ApiResponseCharacters> call, Response<ApiResponseCharacters> response) {
                progressDialog.dismiss();
                if (current_page == 1){
                    putCharacterData(response.body());
                }
                else {
                    charAdapter.addAll(response.body());
                }
                try {
                    ApiResponseCharacters tmp = response.body();
                    if (tmp.getInfo().getNext() != null) {
                        current_page++;
                    }
                } catch (NullPointerException e){
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ApiResponseCharacters> call, Throwable t) {
                Log.e("ApiRequest", t.getMessage());
                progressDialog.dismiss();
                Toast.makeText(MainActivity.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void getEpisodesAt(int page){
        GetDataService service = RetrofitRickMorty.getRetrofitInstance().create(GetDataService.class);
        Call<ApiResponseEpisode> call = service.getAllEpisodes(page);
        call.enqueue(new Callback<ApiResponseEpisode>() {
            @Override
            public void onResponse(Call<ApiResponseEpisode> call, Response<ApiResponseEpisode> response) {
                progressDialog.dismiss();
                if (current_page == 1){
                    putEpisodeData(response.body());
                }
                else {
                    epAdapter.addAll(response.body());
                }

                try {
                    ApiResponseEpisode tmp = response.body();
                    if (tmp.getInfo().getNext() != null) {
                        current_page++;
                    }
                } catch (NullPointerException e){
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ApiResponseEpisode> call, Throwable t) {
                Log.e("ApiRequest", t.getMessage());
                progressDialog.dismiss();
                Toast.makeText(MainActivity.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void getLocationAt(int page){
        GetDataService service = RetrofitRickMorty.getRetrofitInstance().create(GetDataService.class);
        Call<ApiResponseLocation> call = service.getAllLocations(page);
        call.enqueue(new Callback<ApiResponseLocation>() {
            @Override
            public void onResponse(Call<ApiResponseLocation> call, Response<ApiResponseLocation> response) {
                progressDialog.dismiss();
                if (current_page == 1){
                    putLocationData(response.body());
                }
                else {
                    locAdapter.addAll(response.body());
                }

                try {
                    ApiResponseLocation tmp = response.body();
                    if (tmp.getInfo().getNext() != null) {
                        current_page++;
                    }
                } catch (NullPointerException e){
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ApiResponseLocation> call, Throwable t) {
                Log.e("ApiRequest", t.getMessage());
                progressDialog.dismiss();
                Toast.makeText(MainActivity.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    /**
     * Load Character data on the RecyclerView
     * @param response
     */
    private void putCharacterData(ApiResponseCharacters response) {
        charAdapter = new CharacterAdapter(this, response, this);
        recyclerView.setAdapter(charAdapter);
    }

    /**
     * Load Episode data on the RecyclerView
     * @param response
     */
    private void putEpisodeData(ApiResponseEpisode response) {
        epAdapter = new EpisodeAdapter(response, this);
        recyclerView.setAdapter(epAdapter);
    }

    /**
     * Load Location data on the RecyclerView
     * @param response
     */
    private void putLocationData(ApiResponseLocation response) {
        locAdapter = new LocationAdapter(response, this);
        recyclerView.setAdapter(locAdapter);
    }


    /**
     * Load next data at the end of the RecyclerView
     */
    @Override
    public void onScrollEnd(CustomAdapter source) {
        if (source instanceof CharacterAdapter) {
            getCharacterAt(current_page);
        }
        else if (source instanceof EpisodeAdapter) {
            getEpisodesAt(current_page);
        }
        else if (source instanceof LocationAdapter) {
            getLocationAt(current_page);
        }
    }

    //endregion

    //region Navigation

    private void InitNav(){
        navBar = findViewById(R.id.navBar);
        navBar.setItemIconTintList(null);

        BottomNavigationItemView character_item = this.findViewById(R.id.character_item);
        character_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reset();
                navBar.setSelectedItemId(character_item.getId());
                getCharacterAt(current_page);
            }
        });

        BottomNavigationItemView episode_item = findViewById(R.id.episode_item);
        episode_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reset();
                navBar.setSelectedItemId(episode_item.getId());
                getEpisodesAt(current_page);
            }
        });

        BottomNavigationItemView location_item = findViewById(R.id.location_item);
        location_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reset();
                navBar.setSelectedItemId(location_item.getId());
                getLocationAt(current_page);

            }
        });

    }

    private void reset(){
        current_page = 1;
        if (charAdapter != null)
            charAdapter.clear();
        if (epAdapter != null)
            epAdapter.clear();
        if (locAdapter != null)
            locAdapter.clear();
    }

    //endregion
}