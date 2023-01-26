package ParserSmena.model_2;

import java.util.ArrayList;

public class Date
{
    private String date;
    private ArrayList<Movie>movies;

    public Date(String date)
    {
        this.date=date;
        this.movies=new ArrayList<>();
    }

    public String getDate() {
        return date;
    }

    public ArrayList<Movie> getMovies() {
        return movies;
    }
    public void addMovie(String name, String imageURL){
        this.movies.add(new Movie(name, imageURL));
    }
    public Movie returnLastMovie(){return movies.get(movies.size()-1);}
}
