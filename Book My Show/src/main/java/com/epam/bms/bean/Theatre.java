package com.epam.bms.bean;

import java.sql.Time;
import java.util.List;

public class Theatre {
	private int theatreId;
	private String theatreName;
	private List<Time> showtimings;
	
	public int getTheatreId() {
		return theatreId;
	}

	public String getTheatreName() {
		return theatreName;
	}

	public void setTheatreId(int id) {
		this.theatreId = id;
	}

	public void setName(String name) {
		this.theatreName = name;
	}

	public List<Time> getShowtimings() {
		return showtimings;
	}

	public void setShowtimings(List<Time> showtimings) {
		this.showtimings = showtimings;
	}
	
	

}

