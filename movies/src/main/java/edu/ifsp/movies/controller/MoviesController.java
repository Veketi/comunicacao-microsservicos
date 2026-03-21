package edu.ifsp.movies.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.ifsp.movies.model.Movie;

@RestController
@RequestMapping("/api/v1")
public class MoviesController {

	@GetMapping("/movie/{id}")
	public Movie index(@PathVariable Integer id) throws InterruptedException {
		Thread.sleep(5000);
		return new Movie(Integer.toUnsignedLong(id), "Back to the Future II");
	}
}
