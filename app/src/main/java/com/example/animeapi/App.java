package com.example.animeapi;

import android.app.Application;

import com.example.animeapi.data.romote.FilmsApi;
import com.example.animeapi.data.romote.FilmsApiService;
import com.example.animeapi.data.romote.RetrofitClient;

public class App extends Application {

    private RetrofitClient retrofitClient;
    public static FilmsApi api;
    public static FilmsApiService apiService;

    @Override
    public void onCreate() {
        super.onCreate();
        retrofitClient = new RetrofitClient();
        api= retrofitClient.provideFilmApi();
        apiService = new FilmsApiService();
    }
}
