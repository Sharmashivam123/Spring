package com.epam.bms.models;

public class Movie {
	private String movieName;

	public Movie() {
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

}

enum language {
	HINDI, ENGLISH;
}
