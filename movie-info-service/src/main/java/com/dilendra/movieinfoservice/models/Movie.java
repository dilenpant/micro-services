package com.dilendra.movieinfoservice.models;

public class Movie
{
    private String moviId;
    private String name;

    public Movie(String moviId, String name) {
        this.moviId = moviId;
        this.name = name;
    }

    public String getMoviId() {
        return moviId;
    }

    public void setMoviId(String moviId) {
        this.moviId = moviId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
