package org.ru.itdt.smenaparser.ParserSmena;

import org.openqa.selenium.WebDriver;
import java.util.ArrayList;
import java.util.List;

public class Worker {
    final ParserI parser;
    final Loader loader;
    public final List<OnNewData> onNewDataList = new ArrayList<>();
    public final List<OnCompleted> onCompletedList = new ArrayList<>();

    public Worker(final ParserI parser, final String URL) {
        this.parser = parser;
        this.loader = new Loader(URL);
    }

    public void Start() throws InterruptedException {
        Work();
    }

    private void Work() throws InterruptedException {
        final WebDriver driver = loader.GetSourceByPageId();

        for (final OnNewData onNewData : onNewDataList) {
            onNewData.OnNewData(this, parser.Parse(driver));
        }

        driver.quit();

        for (final OnCompleted onCompleted : onCompletedList) {
            onCompleted.OnCompleted(this);
        }
    }
}
