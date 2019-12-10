package com.epam.services;

import java.util.List;

import com.epam.bean.Theatre;

public interface TheatreServices {
	public List<Theatre> getTheatreListByMovie(int movieId);
}
