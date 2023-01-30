package org.ru.itdt.smenaparser.ParserSmena.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Хранит информацию о фильме.
 */
public class Movie {

    /** Название фильма */
    private final String name;

    /** Список кинотеатров, в которых показывают фильм */
    private final List<Cinema> cinemas;

    public Movie(final String name) {
        this.name = name;
        this.cinemas = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Cinema> getCinemas() {
        return cinemas;
    }
}
