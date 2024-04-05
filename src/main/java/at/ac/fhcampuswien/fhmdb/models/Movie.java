package at.ac.fhcampuswien.fhmdb.models;

import at.ac.fhcampuswien.fhmdb.JSONAction;

import java.util.*;

public class Movie implements Comparable<Movie> {
    private String title;
    private String description;
    private List<Genre> genres;

    public Movie(String title, String description, List<Genre> genres) {
        this.title = title;
        this.description = description;
        this.genres = genres;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getGenres() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Genre genres : genres) {
            stringBuilder.append(genres + ", ");
        }
        stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length() - 1);
        return stringBuilder.toString();
    }

    public static List<Movie> initializeMovies() {

        List<Movie> movies = JSONAction.readJsonFile("./movie.json");


        /*List<Genre> genres = new ArrayList<>();
        Collections.addAll(genres, Genre.ACTION, Genre.ADVENTURE);

        movies.add(new Movie("Mew", "This is a catty movie , mew", genres));

        genres = new ArrayList<>();
        Collections.addAll(genres, Genre.DOCUMENTARY);
        movies.add(new Movie("Camonna Tong", "Look at me. You may not like it but this is how a free guy looks like.", genres));

        genres = new ArrayList<>();
        Collections.addAll(genres, Genre.CRIME, Genre.DRAMA);
        movies.add(new Movie("Simba und die Blume", "Dangerous cat eating flowers", genres));

        genres = new ArrayList<>();
        Collections.addAll(genres, Genre.CRIME, Genre.DRAMA);
        movies.add(new Movie("Ein Esel", "Dangerous cat eating flowers", genres));

        genres = new ArrayList<>();
        Collections.addAll(genres, Genre.CRIME, Genre.DRAMA);
        movies.add(new Movie("Eine Irgendwas", "Dangerous cat eating flowers", genres));*/

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
