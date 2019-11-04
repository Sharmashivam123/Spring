package com.epam.bms.models;

import java.time.LocalTime;

public class Theatre {
	private int theatreId;
	private String theatreName;
	private LocalTime time;

	public int getTheatreId() {
		return theatreId;
	}

	public String getTheatreName() {
		return theatreName;
	}

	public void setId(int id) {
		this.theatreId = id;
	}

	public void setName(String name) {
		this.theatreName = name;
	}

	public LocalTime getMovieTime() {
		return time;
	}

	public void setMovieTime(LocalTime time) {
		this.time = time;
	}

}
