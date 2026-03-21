package edu.ifsp.ratings.model;

public class Rating {
	private Long id;
	private int rating;
	private String comment;
	private Movie movie;

	public Rating(Long id, int rating, String comment, Movie movie) {
		this.id = id;
		this.rating = rating;
		this.comment = comment;
		this.movie = movie;
	}

	public Rating(Long id, int rating, String comment) {
		this.id = id;
		this.rating = rating;
		this.comment = comment;
	}

	public Rating () { }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}
}
