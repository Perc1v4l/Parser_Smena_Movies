package ParserSmena.model_2;

import java.util.ArrayList;

public class Head {
    private ArrayList<Date>dates;
    public Head()
    {
        this.dates = new ArrayList<>();
    }

    public ArrayList<Date> getDates() {
        return dates;
    }

    public void addDate(String date){
        this.dates.add(new Date(date));
    }
    public Date returnLastDate(){
        return this.dates.get(this.dates.size()-1);
    }
}
