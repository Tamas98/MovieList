package com.education.example;

import com.education.example.model.Genre;
import com.education.example.model.Movie;
import com.education.example.model.supplier.MovieListSupplier;
import com.education.example.service.DefaultMovieSearcherService;
import com.education.example.service.MovieSearcherService;

import java.util.stream.Collectors;

public class App {

    private static final MovieListSupplier movieListSupplier = new MovieListSupplier();
    private static final MovieSearcherService movieSearcherService = new DefaultMovieSearcherService(movieListSupplier);
    public static void main(String[] args) {
        searchByTitle();
        searchByDirector();
        searchByCastMember();
        searchByGenre();
        searchByDescription();
    }

    private static void searchByTitle() {
        String title = "dummy";
        System.out.println("Search movie by title: " + title);
        System.out.println(movieSearcherService.searchByTitle(title).stream().map(Movie::getTitle).collect(Collectors.joining(", ")));
        System.out.println("------------");
    }

    private static void searchByDirector() {
        String director = "Quentin Tarantino";
        System.out.println("Search movie by director: " + director);
        System.out.println(movieSearcherService.searchByDirector(director).stream().map(Movie::getTitle).collect(Collectors.joining(", ")));
        System.out.println("------------");
    }

    private static void searchByCastMember() {
        String name = "Leonardo DiCaprio";
        System.out.println("Search movie by cast member: " + name);
        System.out.println(movieSearcherService.searchByCastMember(name).stream().map(Movie::getTitle).collect(Collectors.joining(", ")));
        System.out.println("------------");
    }

    private static void searchByGenre() {
        Genre genre = Genre.HORROR;
        System.out.println("Search movie by genre: " + genre);
        System.out.println(movieSearcherService.searchByGenre(genre).stream().map(Movie::getTitle).collect(Collectors.joining(", ")));
        System.out.println("------------");
    }

    private static void searchByDescription() {
        String description = "not";
        System.out.println("Search movie by genre: " + description);
        System.out.println(movieSearcherService.searchByDescription(description).stream().map(Movie::getTitle).collect(Collectors.joining(", ")));
        System.out.println("------------");
    }
}
