package org.ru.itdt.smenaparser.ParserSmena.model;

import java.util.ArrayList;
import java.util.List;

public class Date {
    private final String date;
    private final List<Movie> movies;

    public Date(final String date) {
        this.date = date;
        this.movies = new ArrayList<>();
    }

    public String getDate() {
        return date;
    }

    public List<Movie> getMovies() {
        return movies;
    }
}
