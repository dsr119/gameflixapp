package com.example.gameflix.movie;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    public List<Movie> getAllMovies() {
        return List.of(
                new Movie("The Matrix", 1999),
                new Movie("Inception", 2010),
                new Movie("Interstellar", 2014)
        );
    }

    public Movie getFirstMovie() {
        return getAllMovies().get(0);
    }

    public int getMovieCount() {
        return getAllMovies().size();
    }
}
