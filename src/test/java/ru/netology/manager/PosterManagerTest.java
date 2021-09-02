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

        // в менеджере фильмов меньше чем лимит
        PosterManager posterManager = new PosterManager(3);
        Movie movie = new Movie();
        movie.setName("test");
        posterManager.add(movie);

        Movie newMov = new Movie();
        newMov.setName("new");
        posterManager.add(newMov);
        assertEquals(1, posterManager.getLastMovies(1).length);
        assertArrayEquals(new Movie[]{newMov, movie}, posterManager.getLastMovies(2));
        assertArrayEquals(new Movie[]{newMov}, posterManager.getLastMovies(1));


        // в менеджере столько же сколько задан лимит
        Movie mov3d = new Movie();
        newMov.setName("3d");
        posterManager.add(mov3d);
        assertEquals(3, posterManager.getLastMovies(3).length);
        assertArrayEquals(new Movie[]{mov3d, newMov, movie}, posterManager.getLastMovies(3));

        // в менеджере фильмов больше лимита
        Movie mov4k = new Movie();
        mov4k.setName("4k");
        posterManager.add(mov4k);
        assertEquals("4k", posterManager.getLastMovies(1)[0].getName());
        assertArrayEquals(new Movie[]{mov4k, mov3d}, posterManager.getLastMovies(2));
    }
}
