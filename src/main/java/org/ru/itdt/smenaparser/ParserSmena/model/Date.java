package org.ru.itdt.smenaparser.ParserSmena.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Хранит информацию о дате и фильмах в этот день.
 */
public class Date {

    /** Дата */
    private final String date;

    /** Список показываемых фильмов */
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
