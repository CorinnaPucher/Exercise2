package at.ac.fhcampuswien.fhmdb.models;

import at.ac.fhcampuswien.fhmdb.HomeController;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MovieTest {

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
        moviesActual.add(new Movie("Test Titel 1"));
        moviesActual.add(new Movie("C'est moi et mon amie"));
        moviesActual.add(new Movie("Mach das"));

        Collections.sort(moviesActual);

        List<Movie> moviesExpected = new ArrayList<>();
        moviesExpected.add(new Movie("C'est moi et mon amie"));
        moviesExpected.add(new Movie("Mach das"));
        moviesExpected.add(new Movie("Test Titel 1"));

        assertEquals(moviesExpected,moviesActual);
    }
    @Test
    void if_list_is_sorted_descending() {
        List<Movie> moviesActual = new ArrayList<>();
        moviesActual.add(new Movie("Test Titel 1"));
        moviesActual.add(new Movie("C'est moi et mon amie"));
        moviesActual.add(new Movie("Mach das"));

        Collections.sort(moviesActual);
        Collections.reverse(moviesActual);

        List<Movie> moviesExpected = new ArrayList<>();
        moviesExpected.add(new Movie("Test Titel 1"));
        moviesExpected.add(new Movie("Mach das"));
        moviesExpected.add(new Movie("C'est moi et mon amie"));

        assertEquals(moviesExpected,moviesActual);
    }

    @Test
    void if_query_is_filtering () {
        HomeController controller = new HomeController();
        controller.filter("godfather", "", -1, -1);
        assertEquals(controller.getObservableMovies().get(0).title, "The Godfather");
    }
    @Test
    void if_genre_is_filtering () {
        HomeController controller = new HomeController();
        controller.filter("god", "CRIME", -1, -1);
        assertEquals(controller.getObservableMovies().get(0).title, "City of God");
    }
    @Test
    void if_releaseYear_is_filtering () {
        HomeController controller = new HomeController();
        controller.filter("", "", 1997, -1);
        assertEquals(controller.getObservableMovies().get(0).title, "Life Is Beautiful");
    }
    /*@Test
    void if_ratingFrom_is_filtering () {
        HomeController controller = new HomeController();
        controller.filter("", "", -1, 8.5);
        assertEquals(controller.getObservableMovies().get(0).title, "The Lion King");
    }*/
    @Test
    void if_we_can_find_leon () {
        HomeController controller = new HomeController();
        assertEquals("Leonardo DiCaprio", controller.getMostPopularActor(controller.allMovies));
    }
    @Test
    void if_we_can_get_longest_movietitle () {
        HomeController controller = new HomeController();
        assertEquals(46, controller.getLongestMovieTitle(controller.allMovies));
    }
    @Test
    void if_we_can_get_movies_from_range () {
        HomeController controller = new HomeController();
        assertEquals(3, controller.countMoviesFrom(controller.allMovies, "Quentin Tarantino"));
    }
    @Test
    void if_we_can_get_movies_between_years () {
        HomeController controller = new HomeController();
        assertEquals(4, controller.getMoviesBetweenYears(controller.allMovies, 1997, 2001).size());
    }
}