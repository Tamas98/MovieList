package com.education.example.model.supplier;

import com.education.example.model.Genre;
import com.education.example.model.Movie;

import java.time.LocalDate;
import java.util.*;
import java.util.function.Supplier;

public class MovieListSupplier implements Supplier<List<Movie>> {

    private final Random random = new Random();
    private final List<Movie> movieList;

    @Override
    public List<Movie> get() {
        return this.movieList;
    }

    public MovieListSupplier() {
        movieList = constructMovieList();
    }

    private List<Movie> constructMovieList() {
        List<Movie> movieList = new ArrayList<>();
        List<String> directorList = Arrays.asList("George Lucas", "Steven Spielberg", "Martin Scorsese", "Quentin Tarantino", "Tim Burton");
        List<String> castList = Arrays.asList("Denzel Washington", "Leonardo DiCaprio", "Brad Pitt", "George Clooney", "Matt Damon");
        List<Genre> genreList = Arrays.asList(Genre.values());
        List<String> titleList = Arrays.asList("Revenge of the number ", "Return of the number ", "The dummy ", "The light ", "The shining point ", "Point of no return ", "Software Engineering ", "Who will fail the exams?", "Who did the homework?", "Project randomizer ");


        for(int i = 0; i < 100; i++) {
            movieList.add(Movie.builder()
                    .title(titleList.get(random.nextInt(titleList.size()-1)) + i)
                    .genreList(Arrays.asList(genreList.get(random.nextInt(genreList.size()-1)),
                                genreList.get(random.nextInt(genreList.size()-1))))
                    .castList(Arrays.asList(castList.get(random.nextInt(castList.size()-1)),
                                castList.get(random.nextInt(castList.size()-1))))
                    .directorList(Arrays.asList(directorList.get(random.nextInt(directorList.size()-1)),
                            directorList.get(random.nextInt(directorList.size()-1))))
                    .description("Lorem Ipsum etc. " + (i%9 == 0 ? "test" : "not test"))
                    .rating(random.nextInt(5))
                    .build()
            );
        }

        return movieList;
    }
}
