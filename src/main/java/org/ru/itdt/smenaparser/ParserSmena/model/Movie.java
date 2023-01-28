package org.ru.itdt.smenaparser.ParserSmena.model;

import java.util.ArrayList;
import java.util.List;

public class Movie {
    private final String name;
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
