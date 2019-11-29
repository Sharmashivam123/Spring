package com.epam.bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="theatre")
public class Theatre {
	@Id
	private int theatreId;
	private String theatreName;

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

}
