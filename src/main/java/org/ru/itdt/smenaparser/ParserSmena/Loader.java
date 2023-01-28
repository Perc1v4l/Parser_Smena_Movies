package org.ru.itdt.smenaparser.ParserSmena;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;

public class Loader {
    final String url;

    public Loader(final String URL) {
        url = URL;
    }

    public WebDriver GetSourceByPageId() {
        WebDriver driver = WebDriverManager.chromedriver().create();
        driver.get(url);
        return driver;
    }
}
