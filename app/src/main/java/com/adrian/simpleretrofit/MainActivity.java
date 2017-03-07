package com.adrian.simpleretrofit;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findMovieByYear(2010);
        findMovieByTitle("Superman");
        findMovieByImdbId("tt0096895");
    }

    public void findMovieByYear(final int year) {
        OmdbApiService omdbApiService = OmdbApiService.retrofit.create(OmdbApiService.class);

        Map<String, String> data = new HashMap<>();
        data.put("y", year + "");

        Call<String> call = omdbApiService.findMovieByTitle(data);

        Log.i(TAG, call.request().url().toString());

        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                Log.i(TAG, "onResponse");
                int statusCode = response.code();
                String simpleString = response.body();
                Log.i(TAG, simpleString);
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Log.i(TAG, "onFailure");
                System.out.println(t.getMessage());
            }
        });
    }

    public void findMovieByTitle(final String title) {
        OmdbApiService omdbApiService = OmdbApiService.retrofit.create(OmdbApiService.class);

        Map<String, String> data = new HashMap<>();
        data.put("t", title);

        Call<String> call = omdbApiService.findMovieByTitle(data);

        Log.i(TAG, call.request().url().toString());

        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                Log.i(TAG, "onResponse");
                int statusCode = response.code();
                String simpleString = response.body();
                Log.i(TAG, simpleString);
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Log.i(TAG, "onFailure");
                System.out.println(t.getMessage());
            }
        });
    }

    public void findMovieByImdbId(final String imdbId) {
        OmdbApiService omdbApiService = OmdbApiService.retrofit.create(OmdbApiService.class);

        Map<String, String> data = new HashMap<>();
        data.put("i", imdbId);

        Call<String> call = omdbApiService.findMovieByTitle(data);

        Log.i(TAG, call.request().url().toString());

        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                Log.i(TAG, "onResponse");
                int statusCode = response.code();
                String simpleString = response.body();
                Log.i(TAG, simpleString);
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Log.i(TAG, "onFailure");
                System.out.println(t.getMessage());
            }
        });
    }

}
