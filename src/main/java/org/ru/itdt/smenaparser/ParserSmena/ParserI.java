package org.ru.itdt.smenaparser.ParserSmena;

import org.openqa.selenium.WebDriver;
import org.ru.itdt.smenaparser.ParserSmena.model.Root;

public interface ParserI {
   Root Parse(WebDriver document) throws InterruptedException;
}
