package at.ac.fhcampuswien.fhmdb.models;

import at.ac.fhcampuswien.fhmdb.HomeController;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MovieTest {
/*
    @Test
    void initializeMovies_returns_not_null() {
        // If an Object is returned
        assertNotNull(Movie.initializeMovies());
    }
    @Test
    void initializeMovies_returns_array_that_is_not_empty() {
        int expected = 0;
        int actual = Movie.initializeMovies().size();
        assertNotEquals(expected, actual);
    }
    @Test
    void if_list_is_sorted_ascending() {
        List<Movie> moviesActual = new ArrayList<>();
        moviesActual.add(new Movie("Test Titel 1", "Das ist ein erster Test", null));
        moviesActual.add(new Movie("C'est moi et mon amie", "Das ist ein zweiter Test", null));
        moviesActual.add(new Movie("Mach das", "Das ist ein dritter Test", null));

        Collections.sort(moviesActual);

        List<Movie> moviesExpected = new ArrayList<>();
        moviesExpected.add(new Movie("C'est moi et mon amie", "Das ist ein zweiter Test", null));
        moviesExpected.add(new Movie("Mach das", "Das ist ein dritter Test", null));
        moviesExpected.add(new Movie("Test Titel 1", "Das ist ein erster Test", null));

        assertEquals(moviesExpected,moviesActual);
    }
    @Test
    void if_list_is_sorted_descending() {
        List<Movie> moviesActual = new ArrayList<>();
        moviesActual.add(new Movie("Test Titel 1", "Das ist ein erster Test", null));
        moviesActual.add(new Movie("C'est moi et mon amie", "Das ist ein zweiter Test", null));
        moviesActual.add(new Movie("Mach das", "Das ist ein dritter Test", null));

        Collections.sort(moviesActual);
        Collections.reverse(moviesActual);

        List<Movie> moviesExpected = new ArrayList<>();
        moviesExpected.add(new Movie("Test Titel 1", "Das ist ein erster Test", null));
        moviesExpected.add(new Movie("Mach das", "Das ist ein dritter Test", null));
        moviesExpected.add(new Movie("C'est moi et mon amie", "Das ist ein zweiter Test", null));

        assertEquals(moviesExpected,moviesActual);
    }

    @Test
    void if_searchvalue_is_filtering () {
        String searchValue = "ew";
        Genre genre = null;

        List<Movie> allMovies = new ArrayList<>();
        allMovies.add(new Movie("Test Titel 1", "Das ist ein erster Test", null));
        allMovies.add(new Movie("C'est moi et mon amie", "Das ist ein zweiter Test", null));
        allMovies.add(new Movie("Mach das ew", "Das ist ein dritter Test", null));

        List<Movie> actualMovie = new ArrayList<>();
        actualMovie.addAll(allMovies);

        HomeController.filter(searchValue,genre,actualMovie,allMovies);

        List<Movie> expectedMovie = new ArrayList<>();
        expectedMovie.add(new Movie("Mach das ew", "Das ist ein dritter Test", null));

        assertEquals(expectedMovie,actualMovie);
    }
    @Test
    void if_genre_is_filtering () {
        String searchValue = "";
        Genre genre = Genre.FANTASY;

        List<Genre> genre1 = new ArrayList<>();
        Collections.addAll(genre1, Genre.ACTION, Genre.ADVENTURE);

        List<Genre> genre2 = new ArrayList<>();
        Collections.addAll(genre2, Genre.DOCUMENTARY);

        List<Genre> genre3 = new ArrayList<>();
        Collections.addAll(genre3, Genre.DRAMA, Genre.FANTASY);

        List<Movie> allMovies = new ArrayList<>();
        allMovies.add(new Movie("Test Titel 1", "Das ist ein erster Test", genre1));
        allMovies.add(new Movie("C'est moi et mon amie", "Das ist ein zweiter Test", genre2));
        allMovies.add(new Movie("Mach das ew", "Das ist ein dritter Test", genre3));

        List<Movie> actualMovie = new ArrayList<>();
        actualMovie.addAll(allMovies);

        HomeController.filter(searchValue,genre,actualMovie,allMovies);

        List<Movie> expectedMovie = new ArrayList<>();
        expectedMovie.add(new Movie("Mach das ew", "Das ist ein dritter Test", genre3));

        assertEquals(expectedMovie,actualMovie);
    }
    @Test
    void if_searchvalue_is_not_in_list_but_genre_is_filtering () {
        String searchValue = "ew";
        Genre genre = Genre.DOCUMENTARY;

        List<Genre> genre1 = new ArrayList<>();
        Collections.addAll(genre1, Genre.ACTION, Genre.ADVENTURE);

        List<Genre> genre2 = new ArrayList<>();
        Collections.addAll(genre2, Genre.DOCUMENTARY);

        List<Genre> genre3 = new ArrayList<>();
        Collections.addAll(genre3, Genre.DRAMA, Genre.FANTASY);

        List<Movie> allMovies = new ArrayList<>();
        allMovies.add(new Movie("Test Titel 1", "Das ist ein erster Test", genre1));
        allMovies.add(new Movie("C'est moi et mon amie", "Das ist ein zweiter Test", genre2));
        allMovies.add(new Movie("Mach das ew", "Das ist ein dritter Test", genre3));

        List<Movie> actualMovie = new ArrayList<>();
        actualMovie.addAll(allMovies);

        HomeController.filter(searchValue,genre,actualMovie,allMovies);

        List<Movie> expectedMovie = new ArrayList<>();
        expectedMovie.add(new Movie("Mach das ew", "Das ist ein dritter Test", genre3));

        assertNotEquals(expectedMovie,actualMovie);
    }*/
}