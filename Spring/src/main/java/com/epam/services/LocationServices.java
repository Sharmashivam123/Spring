package com.epam.services;

import java.util.List;

import com.epam.bean.Location;

public interface LocationServices {
	public List<Location> getAreaPinInCity(int cityId) throws RuntimeException;
}
