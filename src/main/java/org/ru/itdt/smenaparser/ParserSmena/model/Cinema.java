package org.ru.itdt.smenaparser.ParserSmena.model;

import java.util.ArrayList;
import java.util.List;

public class Cinema {
    private final String name;
    private final String address;
    private final List<Seans> seanses;

    public Cinema(final String name, final String address) {
        this.name = name;
        this.address = address;
        this.seanses = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public List<Seans> getSeanses() {
        return seanses;
    }
}
