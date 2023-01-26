package ParserSmena.model_2;

public class Seans {
    private String time;
    private String cost;
    public Seans(String time, String cost)
    {
        this.time=time;
        this.cost=cost;
    }

    public String getCost() {
        return cost;
    }

    public String getTime() {
        return time;
    }
}
