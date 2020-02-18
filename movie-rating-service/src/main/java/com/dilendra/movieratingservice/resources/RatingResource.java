package com.dilendra.movieratingservice.resources;

import com.dilendra.movieratingservice.models.Rating;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ratingsdata")
public class RatingResource
{
    @RequestMapping("/{moviId}")
    public Rating getRatings(@PathVariable("moviId") String moviId){

        return new Rating(moviId, 4);
    }

}
