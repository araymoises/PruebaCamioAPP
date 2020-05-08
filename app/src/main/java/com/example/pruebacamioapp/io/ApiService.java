/**
 * Interfaz que determina cada ruta específica o endpoints para las peticiones
 * **/
package com.example.pruebacamioapp.io;

import com.example.pruebacamioapp.model.Movie;
import java.util.ArrayList;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("movies")
    Call<ArrayList<Movie>> getMovies();
}
