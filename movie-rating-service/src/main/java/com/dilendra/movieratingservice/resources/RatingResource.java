package com.dilendra.movieratingservice.resources;

import com.dilendra.movieratingservice.models.Rating;
import com.dilendra.movieratingservice.models.UserRating;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/ratingsdata")
public class RatingResource
{
    @RequestMapping("/{moviId}")
    public Rating getRating(@PathVariable("moviId") String moviId){

        return new Rating(moviId, 4);
    }

    @RequestMapping("users/{moviId}")
    public UserRating getUserRatings(@PathVariable("moviId") String moviId){

        List<Rating> ratings =  Arrays.asList(
                new Rating("1274", 4), new Rating("1234", 0), new Rating("0290", 3)
        );
        UserRating userRating = new  UserRating();
        userRating.setUserRating(ratings);
        return userRating;
    }

}
