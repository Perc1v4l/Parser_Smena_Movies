package ParserSmena;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class Loader {
    String url;

    public Loader(ParserSettings settings){
        url= Settings.BASE_URL;  //задаём url
    }

    public WebDriver GetSourceByPageId()throws IOException {  //запускаем chrome и открываем сайт
        WebDriver driver = WebDriverManager.chromedriver().create();
        driver.get(url);
        return driver;
    }
}
