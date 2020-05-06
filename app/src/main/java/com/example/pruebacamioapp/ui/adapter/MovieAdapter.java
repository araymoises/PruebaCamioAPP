package com.example.pruebacamioapp.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.pruebacamioapp.R;
import com.example.pruebacamioapp.model.Movie;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {
    private ArrayList<Movie> mDataSet;
    private Context context;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textTitle;
        public TextView textOverview;
        public ImageView PosterPath;

        public ViewHolder(View v) {
            super(v);

            textTitle = (TextView) v.findViewById(R.id.textTitle);
            textOverview = (TextView) v.findViewById(R.id.textOverview);
            PosterPath = (ImageView) v.findViewById(R.id.PosterPath);
        }
    }

    public MovieAdapter(Context context) {
        this.context = context;
        mDataSet = new ArrayList<>();
    }

    public void setDataSet(ArrayList<Movie> dataSet) {
        mDataSet = dataSet;
        notifyDataSetChanged();
    }

    @Override
    public MovieAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.movie_view, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int i) {
        Movie movie = mDataSet.get(i);
        holder.textTitle.setText(movie.getTitle());
        holder.textOverview.setText(movie.getOverview());
        Picasso.with(context)
                .load(movie.getImageUrl())
                .into(holder.PosterPath);
    }

    @Override
    public int getItemCount() {
        return mDataSet.size();
    }
}