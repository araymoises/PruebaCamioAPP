package com.example.pruebacamioapp.io;

import com.example.pruebacamioapp.model.Movie;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiService {
    @GET("GetList/{id}")
    Call<List<Movie>> getMovies(@Path("id") int ListId);
}
