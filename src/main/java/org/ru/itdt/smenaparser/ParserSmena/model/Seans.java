package org.ru.itdt.smenaparser.ParserSmena.model;

public class Seans {
    private final String time;
    private final String cost;

    public Seans(final String time, final String cost) {
        this.time = time;
        this.cost = cost;
    }

    public String getCost() {
        return cost;
    }

    public String getTime() {
        return time;
    }
}
