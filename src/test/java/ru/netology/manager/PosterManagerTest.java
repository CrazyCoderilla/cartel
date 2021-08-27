package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Movie;

import static org.junit.jupiter.api.Assertions.*;

public class PosterManagerTest {

    @Test
    public void addTest() {
        PosterManager posterManager = new PosterManager();
        Movie movie = new Movie();
        movie.setName("test");
        posterManager.add(movie);

        assertEquals(movie, posterManager.getLastMovies(1)[0]);

        Movie newMov = new Movie();
        newMov.setName("new");

        posterManager.add(newMov);
        assertEquals(newMov, posterManager.getLastMovies(2)[0]);
    }

    @Test
    public void lastTest() {
        PosterManager posterManager = new PosterManager(5);
        Movie movie = new Movie();
        movie.setName("test");
        posterManager.add(movie);

        Movie newMov = new Movie();
        newMov.setName("new");
        posterManager.add(movie);
        assertEquals(1, posterManager.getLastMovies(1).length);
    }
}
