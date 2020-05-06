package com.example.pruebacamioapp.io;

import com.example.pruebacamioapp.model.Movie;

import java.util.ArrayList;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiService {
    @GET("GetList/{id}")
    Call<ArrayList<Movie>> getMovies(@Path("id") int ListId);
}
