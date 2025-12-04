package com.example.gameflix.movie;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MovieServiceTest {

    // No @Autowired, no Spring context – just a plain instance
    private final MovieService movieService = new MovieService();

    @Test
    void getAllMovies_ShouldReturnList() {
        var movies = movieService.getAllMovies();
        Assertions.assertNotNull(movies);
        Assertions.assertFalse(movies.isEmpty());
    }

    @Test
    void getFirstMovie_ShouldNotBeNull() {
        var movie = movieService.getFirstMovie();
        Assertions.assertNotNull(movie);
        Assertions.assertNotNull(movie.getTitle());
    }

    @Test
    void getMovieCount_ShouldMatchExpectedSize() {
        int count = movieService.getMovieCount();
        Assertions.assertEquals(3, count); // adjust if you change the list
    }
}
