package edu.ifsp.ratings.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import edu.ifsp.ratings.model.Movie;
import edu.ifsp.ratings.model.Rating;

@RestController
@RequestMapping("/api/v1")
public class RatingController {

	RestTemplate restTemplate;

	public RatingController(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	@GetMapping("/ratings")
	public Rating index() {

		Rating rating = new Rating(1L, 9, "Ótimo filme!");

		Movie movie = restTemplate.getForObject("http://movies:8081/api/v1/movie/1", Movie.class);

		rating.setMovie(movie);

		return rating;
	}
}
