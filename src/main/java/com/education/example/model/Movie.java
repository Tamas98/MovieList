package com.education.example.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Movie {

    private String title;
    private List<String> directorList;
    private List<Genre> genreList;
    private String description;
    private List<String> castList;
    private int rating;

}
