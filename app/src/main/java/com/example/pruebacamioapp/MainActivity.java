package com.example.pruebacamioapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import com.example.pruebacamioapp.io.ApiAdapter;
import com.example.pruebacamioapp.model.Movie;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private TextView mJsonTxtView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mJsonTxtView = (TextView) findViewById(R.id.jsonText);
        getMovies();
    }

    private void getMovies(){
        Call<List<Movie>> call = ApiAdapter.getApiService().getMovies(3);
        call.enqueue(new Callback<List<Movie>>() {
            @Override
            public void onResponse(Call<List<Movie>> call, Response<List<Movie>> response) {
                if(!response.isSuccessful()){
                    mJsonTxtView.setText("Codigo: "+response.code());
                    return;
                }
                List<Movie> moviesList = response.body();
                mJsonTxtView.setText("");
                for(Movie movie: moviesList){
                    String content = "";
                    content += "id: "+movie.getId() + "\n";
                    content += "title: "+movie.getTitle() + "\n";
                    content += "overview: "+movie.getOverview() + "\n\n";
                    mJsonTxtView.append(content);
                }
            }

            @Override
            public void onFailure(Call<List<Movie>> call, Throwable t) {
                mJsonTxtView.setText(t.getMessage());
            }
        });
    }
}
