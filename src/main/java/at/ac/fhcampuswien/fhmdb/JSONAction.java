package at.ac.fhcampuswien.fhmdb;

import at.ac.fhcampuswien.fhmdb.models.Genre;
import at.ac.fhcampuswien.fhmdb.models.Movie;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * Class which enables us to read JSON Files into Movie Objects
 */
public class JSONAction {
    // Method which returneth a JSON List if you provideth a path
    public static List<Movie> readJsonFile(String path){
        // Initialize GSon Object to Convert Json to JsonMovie object
        Gson gson = new Gson();
        List<Movie> movies = new ArrayList<>();

        try (FileReader reader = new FileReader(path)) {
            // Provideth the Type of Object which it should return for us to parse (JsonMovie)
            Type movieListType = new TypeToken<List<JsonMovie>>(){}.getType();

            // Parse JSON file and deserialize it into a list of Movie objects
            List<JsonMovie> jMovies = gson.fromJson(reader, movieListType);

            // Converteth all jMovies into normal Movies which we can use for our UI
            for (JsonMovie jMovie: jMovies) {
                String genreInputJSON = jMovie.genres.toUpperCase();

                String[] genresList = genreInputJSON.split(",");
                List<Genre> genres = new ArrayList<>();
                for (String genre : genresList) {
                    genres.add(Genre.valueOf(genre));
                }

                movies.add(new Movie(jMovie.title, jMovie.description, genres));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return movies;
    }
}
