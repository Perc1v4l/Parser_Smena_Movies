package ParserSmena;
import ParserSmena.model_2.Head;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
public class Parser2 implements ParserI<ArrayList<String>>
{
    @Override
    public Head Parse(WebDriver driver) throws InterruptedException {

        Head list = new Head();

        WebElement l_dates = driver.findElement(By.cssSelector("div[class^='EventFilters__FiltersDaysSlider-sc']"));
        List<WebElement>dates = l_dates.findElements(By.tagName("a"));
        int len = dates.size();
        for (int i = 0; i < len; i++)
        {
            WebElement date = dates.get(i);
            //if(i!=0)
                date.click();
            WebElement dateText = date.findElement(By.tagName("small"));
            list.addDate(dateText.getText());

            WebElement l_movies = driver.findElement(By.cssSelector("div[class='EventList__EventListWrap-sc-14wck6-2 kxVNGK']"));
            List<WebElement>movies = l_movies.findElements(By.cssSelector("div[class^='EventList__Event-sc-14wck6-3 dKUEol event']"));
            for (int j = 0; j < movies.size(); j++)
            {
                //Thread.sleep(1000);
                WebElement movie = movies.get(j);
                WebElement img = movie.findElement(By.cssSelector("div[class^='Poster']"));
                WebElement img2 = img.findElement(By.tagName("img"));
                String src = img2.getAttribute("src");
                //WebElement movieName = movie.findElement(By.cssSelector("div[class='event-name']"));
                WebElement movieName = movie.findElement(By.tagName("h2"));
                WebElement movieName2 = movieName.findElement(By.tagName("a"));
                list.returnLastDate().addMovie(movieName2.getText(), src);

                WebElement l_cinemas = movie.findElement(By.cssSelector("div[class^='EventSchedule__Schedule-sc']"));
                List<WebElement> cinemas = l_cinemas.findElements(By.cssSelector("div[class='facility']"));
                for (WebElement cinema : cinemas) {
                    String cinemaName = cinema.findElement(By.tagName("span")).getText();
                    String cinemaAddress = cinema.findElement(By.tagName("small")).getText();
                    list.returnLastDate().returnLastMovie().addCinema(cinemaName, cinemaAddress);

                    WebElement l_seanses = cinema.findElement(By.cssSelector("div[class='shows']"));
                    List<WebElement> seanses = l_seanses.findElements(By.cssSelector("div[class^='Show-sc']"));
                    for (WebElement seans : seanses) {
                        WebElement time = seans.findElement(By.cssSelector("div[class='show-time']"));
                        WebElement price = seans.findElement(By.cssSelector("div[class^='Show__Price']"));
                        list.returnLastDate().returnLastMovie().returnLastCinema().addSeans(time.getText(),price.getText());
                    }
                }
            }
        }
        return list;
    }
}
