package com.example.pruebacamioapp.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.pruebacamioapp.R;
import com.example.pruebacamioapp.model.Movie;
import java.util.ArrayList;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {
    private ArrayList<Movie> mDataSet;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textView;
        public ViewHolder(TextView tv) {
            super(tv);
            textView = tv;
        }
    }

    public MovieAdapter() {
        mDataSet = new ArrayList<>();
    }

    public void setDataSet(ArrayList<Movie> dataSet) {
        mDataSet = dataSet;
        notifyDataSetChanged();
    }

    @Override
    public MovieAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        TextView tv = (TextView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.movie_view, parent, false);
        return new ViewHolder(tv);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int i) {
        holder.textView.setText(mDataSet.get(i).getTitle());
    }

    @Override
    public int getItemCount() {
        return mDataSet.size();
    }
}