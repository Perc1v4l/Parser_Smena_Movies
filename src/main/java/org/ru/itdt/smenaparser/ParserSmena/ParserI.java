package org.ru.itdt.smenaparser.ParserSmena;

import org.openqa.selenium.WebDriver;
import org.ru.itdt.smenaparser.ParserSmena.model.DatesContainer;

public interface ParserI {
   DatesContainer Parse(WebDriver document) throws InterruptedException;
}
