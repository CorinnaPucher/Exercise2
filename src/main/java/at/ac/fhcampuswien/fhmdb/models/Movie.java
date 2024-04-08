package at.ac.fhcampuswien.fhmdb.models;

import at.ac.fhcampuswien.fhmdb.JSONAction;
import at.ac.fhcampuswien.fhmdb.JSONMovie;
import at.ac.fhcampuswien.fhmdb.MovieAPI;

import java.util.*;

public class Movie implements Comparable<Movie> {
    public String id;
    public String title;
    public String[] genres;
    public int releaseYear;
    public String description;
    public String imgUrl;
    public int lengthInMinutes;
    public String[] directors;
    public String[] writers;
    public String[] mainCast;
    public double rating;

    public Movie(JSONMovie jsonMovie) {
        this.id = jsonMovie.id;
        this.title = jsonMovie.title;
        this.genres = jsonMovie.genres;
        this.releaseYear = jsonMovie.releaseYear;
        this.description = jsonMovie.description;
        this.imgUrl = jsonMovie.imgUrl;
        this.lengthInMinutes = jsonMovie.lengthInMinutes;
        this.directors = jsonMovie.directors;
        this.writers = jsonMovie.writers;
        this.mainCast = jsonMovie.mainCast;
        this.rating = jsonMovie.rating;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getGenres() {
        StringBuilder stringBuilder = new StringBuilder();
        for (String genre : genres) {
            stringBuilder.append(genre + ", ");
        }
        stringBuilder.delete(stringBuilder.length()-2,stringBuilder.length()-1);
        return stringBuilder.toString();
    }

    public static List<Movie> initializeMovies() {
        List<Movie> movies = JSONAction.parseJSON(MovieAPI.sendRequest());
        return movies;
    }

    @Override
    public int compareTo(Movie o) {
        int shortestLength = Math.min(o.getTitle().length(), getTitle().length());
        for (int i = 0; i < shortestLength; i++) {
            if (Character.toLowerCase(getTitle().charAt(i)) > Character.toLowerCase(o.getTitle().charAt(i))) {
                // Defines the sorting priority (title 1 comes after title 2)
                return 1;
            } else if (Character.toLowerCase(getTitle().charAt(i)) < Character.toLowerCase(o.getTitle().charAt(i))) {
                // Defines the sorting priority (title 1 comes before title 2)
                return -1;
            }
        }
        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null) return false;
        Movie m = (Movie) obj;
        if(m.getTitle().equals(this.getTitle())) return true;
        return super.equals(obj);
    }
}
