package ParserSmena.model_2;



import java.util.ArrayList;

public class Movie {
    private String name;
    private String imageURL;

    private ArrayList<Cinema> cinemas;

    public Movie(String name, String imageURL)
    {
        this.name = name;
        this.cinemas=new ArrayList<>();
        this.imageURL = imageURL;
    }
    public String getName() {return name;}
    public String getImageURL(){return imageURL;}

    public ArrayList<Cinema> getCinemas() {
        return cinemas;
    }
    public void addCinema(String name, String address){
        cinemas.add(new Cinema(name,address));
    }
    public Cinema returnLastCinema(){return cinemas.get(cinemas.size()-1);}
}
