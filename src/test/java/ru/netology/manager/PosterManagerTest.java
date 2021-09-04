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
    public void lessLimit() {
        PosterManager posterManager = new PosterManager(2);
        Movie movie = new Movie();
        movie.setName("test");
        posterManager.add(movie);
        assertArrayEquals(new Movie[]{movie}, posterManager.getLastMovies(1));
    }

    @Test
    public void equalLimit() {
        PosterManager posterManager = new PosterManager(1);
        Movie movie = new Movie();
        movie.setName("test");
        posterManager.add(movie);
        assertArrayEquals(new Movie[]{movie}, posterManager.getLastMovies(1));
    }

    @Test
    public void moreLimit() {
        PosterManager posterManager = new PosterManager(1);
        Movie movie = new Movie();
        movie.setName("test");
        posterManager.add(movie);
        posterManager.add(movie);
        assertArrayEquals(new Movie[]{movie}, posterManager.getLastMovies(1));
        assertArrayEquals(new Movie[]{movie, movie}, posterManager.getLastMovies(2));
    }
}
