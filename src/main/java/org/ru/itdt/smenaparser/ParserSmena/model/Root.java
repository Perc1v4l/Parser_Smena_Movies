package org.ru.itdt.smenaparser.ParserSmena.model;

import java.util.ArrayList;
import java.util.List;

public class Root {
    private final List<Date> dates;

    public Root() {
        this.dates = new ArrayList<>();
    }

    public List<Date> getDates() {
        return dates;
    }
}
