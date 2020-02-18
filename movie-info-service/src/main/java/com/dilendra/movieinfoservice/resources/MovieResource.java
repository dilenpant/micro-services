package com.dilendra.movieinfoservice.resources;

import com.dilendra.movieinfoservice.models.Movie;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movies")
public class MovieResource
{
    @RequestMapping("/{moviId}")
    public Movie getMovie(@PathVariable("moviId") String moviId){

        return new Movie(moviId, "Mov01");
    }
}
