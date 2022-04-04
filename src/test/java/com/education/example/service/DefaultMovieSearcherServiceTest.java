package com.education.example.service;

import com.education.example.model.Movie;
import com.education.example.model.supplier.MovieListSupplier;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class DefaultMovieSearcherServiceTest {

    private final MovieListSupplier movieListSupplier = new MovieListSupplier();

    private DefaultMovieSearcherService underTest;

    @BeforeEach
    public void setup() {
        underTest = new DefaultMovieSearcherService(movieListSupplier);
    }

    private Stream<String> titleProvider() {
        return Stream.of("dummy", "fail", "The");
    }

    @Test
    public void testSearchByTitleShouldSearchByTheGivenTitleWithOneTitle() {
        // GIVEN
        String title = "dummy";
        List<Movie> expected = movieListSupplier.get().stream().filter(movie -> movie.getTitle().contains(title)).toList();

        // WHEN
        List<Movie> actual = underTest.searchByTitle(title);

        // THEN
        Assertions.assertEquals(expected.size(), actual.size());
        for(Movie movie: expected) {
            Assertions.assertTrue(actual.contains(movie));
        }
    }

    @ParameterizedTest
    @MethodSource("titleProvider")
    public void testSearchByTitleShouldSearchByTheGivenTitle(String title) {
        // GIVEN
        List<Movie> expected = movieListSupplier.get().stream().filter(movie -> movie.getTitle().contains(title)).toList();

        // WHEN
        List<Movie> actual = underTest.searchByTitle(title);

        // THEN
        Assertions.assertEquals(expected.size(), actual.size());
        for(Movie movie: expected) {
            Assertions.assertTrue(actual.contains(movie));
        }
    }

    @AfterEach
    public void tearDown() {
        underTest = null;
    }
}
