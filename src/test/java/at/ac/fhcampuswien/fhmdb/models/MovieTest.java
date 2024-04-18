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
    @Test
    void if_ratingFrom_is_filtering () {
        HomeController controller = new HomeController();
        controller.filter("", "", -1, 9.3);
        assertEquals(controller.getObservableMovies().get(0).title, "The Shawshank Redemption");
    }
    @Test
    void if_we_can_find_most_occuring_actor () {
        HomeController controller = new HomeController();
        Movie theGodfather = new Movie(
                "a00b56aa-0eaf-4332-a02d-736910950128",
                "The Godfather",
                new String[] {"Drama"},
                1972,
                "The aging patriarch of an organized crime dynasty transfers control of his clandestine empire to his reluctant son.",
                "https://m.media-amazon.com/images/M/MV5BM2MyNjYxNmUtYTAwNi00MTYxLWJmNWYtYzZlODY3ZTk3OTFlXkEyXkFqcGdeQXVyNzkwMjQ5NzM@._V1_.jpg",
                175,
                new String[] {"Francis Ford Coppola"},
                new String[] {"Mario Puzo", "Francis Ford Coppola"},
                new String[] {"Marlon Brando", "Al Pacino", "James Caan", "Leonardo DiCaprio"},
                9.2
        );

        // Example movie 2: The Shawshank Redemption
        Movie shawshankRedemption = new Movie(
                "16f94a79-7804-4d73-bab9-6cf415b30182",
                "The Shawshank Redemption",
                new String[] {"Drama"},
                1994,
                "Two imprisoned men bond over a number of years, finding solace and eventual redemption through acts of common decency.",
                "https://m.media-amazon.com/images/M/MV5BNDE3ODcxYzMtY2YzZC00NmNlLWJiNDMtZDViZWM2MzIxZDYwXkEyXkFqcGdeQXVyNjAwNDUxODI@._V1_.jpg",
                142,
                new String[] {"Frank Darabont"},
                new String[] {"Stephen King", "Frank Darabont"},
                new String[] {"Tim Robbins", "Morgan Freeman", "Bob Gunton", "Leonardo DiCaprio"},
                9.3
        );

        // Example movie 3: The Dark Knight
        Movie theDarkKnight = new Movie(
                "8ca193d8-7879-42ed-820e-6230b52746a3",
                "The Dark Knight",
                new String[] {"Action", "Crime", "Drama"},
                2008,
                "When the menace known as the Joker wreaks havoc and chaos on the people of Gotham, the caped crusader must come to terms with one of the greatest psychological tests of his ability to fight injustice.",
                "https://m.media-amazon.com/images/M/MV5BMTk4ODQzNDY3Ml5BMl5BanBnXkFtZTcwODA0NTM4Nw@@._V1_FMjpg_UX1000_.jpg",
                152,
                new String[] {"Christopher Nolan"},
                new String[] {"Jonathan Nolan", "Christopher Nolan"},
                new String[] {"test", "Aaron Eckhart"},
                9.0
        );
        List<Movie> testList = new ArrayList<>();
        testList.add(theDarkKnight);
        testList.add(theGodfather);
        testList.add(shawshankRedemption);

        assertEquals("Leonardo DiCaprio", controller.getMostPopularActor(testList));
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