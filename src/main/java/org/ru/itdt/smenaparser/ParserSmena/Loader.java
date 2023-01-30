package org.ru.itdt.smenaparser.ParserSmena;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;

/**
 * Загрузчик страницы
 */
public class Loader {

    /** Ссылка на сайт */
    final String url;

    public Loader(final String URL) {
        url = URL;
    }

    /**
     * Запуск браузера и переход по ссылке
     * @return Страницу, открытую в браузере
     */
    public WebDriver GetSourceByPageId() {
        WebDriver driver = WebDriverManager.chromedriver().create();
        driver.get(url);
        return driver;
    }
}
