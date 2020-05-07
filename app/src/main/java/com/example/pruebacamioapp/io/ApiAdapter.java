/**
 * Clase que instancia u objeto retrofit (patrón de diseño Singleton)
 * Define la ruta base del API de Laravel
 * **/
package com.example.pruebacamioapp.io;

import com.example.pruebacamioapp.BuildConfig;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiAdapter {
    private static ApiService API_SERVICE;

    public static ApiService getApiService() {
        if (API_SERVICE == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BuildConfig.API_URL) //Accediendo a BuildConfig para obtener la baseUrl de la api
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            API_SERVICE = retrofit.create(ApiService.class);
        }
        return API_SERVICE;
    }
}
