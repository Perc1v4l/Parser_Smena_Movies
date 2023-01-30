package org.ru.itdt.smenaparser.ParserSmena.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Хранит список дат
 */
public class DatesContainer {

    /** Список дат показов фильмов */
    private final List<Date> dates;

    public DatesContainer() {
        this.dates = new ArrayList<>();
    }

    public List<Date> getDates() {
        return dates;
    }
}
