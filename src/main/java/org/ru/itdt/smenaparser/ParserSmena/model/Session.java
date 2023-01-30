package org.ru.itdt.smenaparser.ParserSmena.model;

/**
 * Сеанс
 */
public class Session {

    /** Время начала показа */
    private final String time;

    /** Стоимость билета */
    private final String cost;

    public Session(final String time, final String cost) {
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
