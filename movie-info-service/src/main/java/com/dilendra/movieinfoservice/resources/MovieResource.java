package com.dilendra.movieinfoservice.resources;

import com.dilendra.movieinfoservice.models.Movie;
import com.dilendra.movieinfoservice.models.MovieSummary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/movies")
public class MovieResource
{
    @Value("${api.key}")
    private String apiKey;

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/{moviId}")
    public Movie getMovie(@PathVariable("moviId") String moviId){

        MovieSummary movieSummary = restTemplate.getForObject("https://api.themoviedb.org/3/movie/" + moviId + "?api_key=" + apiKey, MovieSummary.class);

        return new Movie(moviId, movieSummary.getTitle());
    }
}
