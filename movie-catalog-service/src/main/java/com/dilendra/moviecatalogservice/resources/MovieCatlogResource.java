package com.dilendra.moviecatalogservice.resources;

import com.dilendra.moviecatalogservice.models.CatalogItem;
import com.dilendra.moviecatalogservice.models.Movie;
import com.dilendra.moviecatalogservice.models.Rating;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/catalog")
public class MovieCatlogResource
{
    @RequestMapping("/{userId}")
    public List<CatalogItem> getCatlog(@PathVariable("userId") String userId){

        RestTemplate restTemplet = new RestTemplate();


        // List of Ratings
List<Rating> ratings = Arrays.asList( new Rating("M001", 5),
        new Rating("M002", 5));

        return  ratings.stream().map(rating ->{

            Movie movie = restTemplet.getForObject("http://localhost:8082/movies/" + rating.getMovieId(), Movie.class);

            return new CatalogItem(movie.getName(), "New", rating.getRating());
        })
                .collect(Collectors.toList());

//        return Collections.singletonList(
//                new CatalogItem("Raja", "New", 4)

    }
}
