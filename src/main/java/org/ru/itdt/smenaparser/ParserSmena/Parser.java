package org.ru.itdt.smenaparser.ParserSmena;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.ru.itdt.smenaparser.ParserSmena.model.*;
import java.util.List;

/**
 * Парсинг
 */
public class Parser implements ParserI {

    /**
     * Парсинг страницы
     * @param driver драйвер бразера
     * @return список дат
     */
    @Override
    public DatesContainer Parse(final WebDriver driver) {
        final DatesContainer list = new DatesContainer();

        final List<WebElement> dates = driver
                .findElement(By.cssSelector("div[class^='EventFilters__FiltersDaysSlider-sc']"))
                .findElements(By.tagName("a"));

        for (final WebElement date : dates) {
            date.click();
            list.getDates().add(new Date(date.findElement(By.tagName("small")).getText()));

            final List<WebElement> movies = driver
                    .findElement(By.cssSelector("div[class='EventList__EventListWrap-sc-14wck6-2 kxVNGK']"))
                    .findElements(By.cssSelector("div[class^='EventList__Event-sc-14wck6-3 dKUEol event']"));

            for (final WebElement movie : movies) {
                list.getDates()
                        .get(list.getDates().size() - 1)
                        .getMovies()
                        .add(new Movie(movie
                                .findElement(By.tagName("h2"))
                                .findElement(By.tagName("a"))
                                .getText()));
                final List<WebElement> cinemas = movie
                        .findElement(By.cssSelector("div[class^='EventSchedule__Schedule-sc']"))
                        .findElements(By.cssSelector("div[class='facility']"));

                for (final WebElement cinema : cinemas) {
                    list.getDates()
                            .get(list.getDates().size() - 1)
                            .getMovies()
                            .get(list.getDates().get(list.getDates().size() - 1).getMovies().size() - 1)
                            .getCinemas().add(new Cinema(cinema.findElement(By.tagName("span"))
                                    .getText(),
                                    cinema.findElement(By.tagName("small"))
                                            .getText()));

                    final List<WebElement> sessions = cinema
                            .findElement(By.cssSelector("div[class='shows']"))
                            .findElements(By.cssSelector("div[class^='Show-sc']"));

                    for (final WebElement session : sessions) {
                        list.getDates()
                                .get(list.getDates().size() - 1)
                                .getMovies()
                                .get(list.getDates().get(list.getDates().size() - 1).getMovies().size() - 1)
                                .getCinemas()
                                .get(list.getDates().get(list.getDates().size() - 1)
                                        .getMovies().get(list.getDates().get(list.getDates().size() - 1).getMovies().size() - 1)
                                        .getCinemas().size() - 1)
                                .getSessions().add(new Session(session.findElement(By.cssSelector("div[class='show-time']"))
                                        .getText(),
                                        session
                                                .findElement(By.cssSelector("div[class^='Show__Price']"))
                                                .getText()));
                    }
                }
            }
        }
        return list;
    }
}