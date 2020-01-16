package com.epam.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TheatreShowtimingMovie")
public class TheatreTimingMovieMapping {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int mappingId;
	@OneToOne
	@JoinColumn(name = "theatreId")
	private Theatre theatre;
	@OneToOne
	@JoinColumn(name = "movieId")
	private Movie movie;
	@OneToOne
	@JoinColumn(name = "timingId")
	private ShowTimings timing;

	public Theatre getTheatre() {
		return theatre;
	}

	public void setTheatre(Theatre theatre) {
		this.theatre = theatre;
	}

	public Movie getMovieList() {
		return movie;
	}

	public void setMovieList(Movie movieList) {
		this.movie = movieList;
	}

	public ShowTimings getTimingList() {
		return timing;
	}

	public void setTimingList(ShowTimings timingList) {
		this.timing = timingList;
	}

	public int getMappingId() {
		return mappingId;
	}

	public void setMappingId(int mappingId) {
		this.mappingId = mappingId;
	}

}
