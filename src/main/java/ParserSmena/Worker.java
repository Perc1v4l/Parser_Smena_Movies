package ParserSmena;


import ParserSmena.model_2.*;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.util.ArrayList;

public class Worker<T> {
    ParserI<T> parser;
    ParserSettings parserSettings;
    Loader loader;
    boolean isActive;

    public ArrayList<OnNewData> onNewDataList = new ArrayList<>();
    public ArrayList<OnCompleted> onCompletedList = new ArrayList<>();

    public ParserI<T> getParser() {
        return parser;
    }

    public ParserSettings getParserSettings() {
        return parserSettings;
    }

    public void setParser(ParserI<T> parser) {
        this.parser = parser;
    }

    public void setParserSettings(ParserSettings parserSettings) {
        this.parserSettings = parserSettings;
        loader=new Loader(parserSettings);
    }

    public void Start() throws IOException, InterruptedException {
        isActive=true;
        Worker();
    }

    public void Abort(){
        isActive=false;
    }

    public Worker(ParserI<T> parser) {
        this.parser = parser;
    }

    private void Worker() throws IOException, InterruptedException {
        if(!isActive){
            onCompletedList.get(0).OnCompleted(this);
            return;
        }
        WebDriver driver = loader.GetSourceByPageId();
        Head result = parser.Parse(driver);
        driver.quit();
        onNewDataList.get(0).OnNewData(this,result);

        onCompletedList.get(0).OnCompleted(this);
        isActive = false;
    }
}
