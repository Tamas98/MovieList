package com.education.example.service;

import com.education.example.model.Genre;
import com.education.example.model.Movie;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface MovieSearcherService {

    List<Movie> searchByTitle(String title);
    List<Movie> searchByDirector(String director);
    List<Movie> searchByCastMember(String name);
    List<Movie> searchByGenre(Genre genre);
    List<Movie> searchByDescription(String desc);

}
