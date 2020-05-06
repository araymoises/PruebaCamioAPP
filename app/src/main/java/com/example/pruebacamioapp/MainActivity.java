package com.example.pruebacamioapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.example.pruebacamioapp.ui.adapter.MovieAdapter;
import com.example.pruebacamioapp.io.ApiAdapter;
import com.example.pruebacamioapp.model.Movie;
import java.util.ArrayList;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private MovieAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.RecyclerViewMovies);

        mRecyclerView.setHasFixedSize(true);

        LinearLayoutManager mlayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mlayoutManager);

        mAdapter = new MovieAdapter();
        mRecyclerView.setAdapter(mAdapter);

        getMovies();
    }

    private void getMovies(){
        Call<ArrayList<Movie>> call = ApiAdapter.getApiService().getMovies(3);
        call.enqueue(new Callback<ArrayList<Movie>>() {
            @Override
            public void onResponse(Call<ArrayList<Movie>> call, Response<ArrayList<Movie>> response) {
                if(response.isSuccessful()) {
                    ArrayList<Movie> moviesList = response.body();
                    mAdapter.setDataSet(moviesList);
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Movie>> call, Throwable t) {

            }
        });
    }
}
