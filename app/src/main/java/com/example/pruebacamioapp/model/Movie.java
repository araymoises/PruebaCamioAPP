package com.example.pruebacamioapp.model;

public class Movie {
    private int id;
    private String title;
    private String overview;
    private String poster_path;

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getOverview() {
        return overview;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public String getImageUrl() {
        return "https://image.tmdb.org/t/p/w500/"+this.poster_path;
    }
}
