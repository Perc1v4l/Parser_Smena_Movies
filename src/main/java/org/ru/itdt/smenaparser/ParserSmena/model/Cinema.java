package org.ru.itdt.smenaparser.ParserSmena.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Хранит информацию о кинотеатре
 */
public class Cinema {

    /** Название кинотеатра */
    private final String name;

    /** Адрес кинотеатра */
    private final String address;

    /** Список сенсов */
    private final List<Session> sessions;

    public Cinema(final String name, final String address) {
        this.name = name;
        this.address = address;
        this.sessions = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public List<Session> getSessions() {
        return sessions;
    }
}
