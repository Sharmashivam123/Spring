package com.epam.bean;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "location")
public class Location {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int locationId;
	private String locationName;
	@ManyToMany(targetEntity = Movie.class)
	private List<Movie> movieList;

	public int getLocationId() {
		return locationId;
	}

	public void setLocationId(int pincode) {
		this.locationId = pincode;
	}

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String areaName) {
		this.locationName = areaName;
	}

	public List<Movie> getMovieList() {
		return movieList;
	}

	public void setMovieList(List<Movie> movieList) {
		this.movieList = movieList;
	}

}
