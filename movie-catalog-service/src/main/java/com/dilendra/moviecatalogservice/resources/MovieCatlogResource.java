package com.dilendra.moviecatalogservice.resources;

import com.dilendra.moviecatalogservice.models.CatalogItem;
import com.dilendra.moviecatalogservice.models.Movie;
import com.dilendra.moviecatalogservice.models.Rating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/catalog")
public class MovieCatlogResource {

    @Autowired
    private RestTemplate restTemplet;
    @Autowired
    private WebClient.Builder webClientBuilder;

    @RequestMapping("/{userId}")
    public List<CatalogItem> getCatlog(@PathVariable("userId") String userId) {


        // List of Ratings
        List<Rating> ratings = Arrays.asList(new Rating("M001", 1),
                new Rating("M002", 5), new Rating("M003", 2), new Rating("M004", 4));

        return ratings.stream().map(rating -> {

            //  Movie movie = restTemplet.getForObject("http://localhost:8082/movies/" + rating.getMovieId(), Movie.class);

            Movie movie = webClientBuilder.build()
                    .get()
                    .uri("http://localhost:8082/movies/" + rating.getMovieId())
                    .retrieve()
                    .bodyToMono(Movie.class)
                    .block();

            return new CatalogItem(movie.getName(), "New", rating.getRating());
        }).collect(Collectors.toList());

//        return Collections.singletonList(
//                new CatalogItem("Raja", "New", 4)

    }
}
