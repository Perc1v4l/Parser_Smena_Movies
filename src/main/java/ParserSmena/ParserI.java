package ParserSmena;


import ParserSmena.model_2.*;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

public interface ParserI<T> {
   Head Parse(WebDriver document) throws InterruptedException;
}
