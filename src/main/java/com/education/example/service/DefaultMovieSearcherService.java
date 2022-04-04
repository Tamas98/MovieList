package com.education.example.service;

import com.education.example.model.Genre;
import com.education.example.model.Movie;
import com.education.example.model.supplier.MovieListSupplier;

import java.util.List;
import java.util.stream.Collectors;

public class DefaultMovieSearcherService implements MovieSearcherService {

    private final MovieListSupplier movieListSupplier;
    private final List<Movie> movieList;

    public DefaultMovieSearcherService(MovieListSupplier movieListSupplier) {
        this.movieListSupplier = movieListSupplier;
        movieList = movieListSupplier.get();
    }

    @Override
    public List<Movie> searchByTitle(String title) {
        return movieList.stream().filter(movie -> movie.getTitle().contains(title)).collect(Collectors.toList());
    }

    @Override
    public List<Movie> searchByDirector(String director) {
        return movieList.stream().filter(movie -> movie.getDirectorList().contains(director)).collect(Collectors.toList());
    }

    @Override
    public List<Movie> searchByCastMember(String name) {
        return movieList.stream().filter(movie -> movie.getCastList().contains(name)).collect(Collectors.toList());
    }

    @Override
    public List<Movie> searchByGenre(Genre genre) {
        return movieList.stream().filter(movie -> movie.getGenreList().contains(genre)).collect(Collectors.toList());
    }

    @Override
    public List<Movie> searchByDescription(String desc) {
        return movieList.stream().filter(movie -> movie.getDescription().contains(desc)).collect(Collectors.toList());
    }
}
