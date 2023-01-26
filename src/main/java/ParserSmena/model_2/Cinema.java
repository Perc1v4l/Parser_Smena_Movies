package ParserSmena.model_2;

import java.util.ArrayList;

public class Cinema {
    private String name;
    private String address;
    private ArrayList<Seans> seanses;
    public Cinema(String name, String address)
    {
        this.name=name;
        this.address=address;
        this.seanses=new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public ArrayList<Seans> getSeanses() {
        return seanses;
    }
    public void addSeans(String time, String cost){
        this.seanses.add(new Seans(time,cost));
    }
}
