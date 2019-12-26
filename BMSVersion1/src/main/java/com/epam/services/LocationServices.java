package com.epam.services;

import java.util.List;

import com.epam.bean.Location;

public interface LocationServices {
	public List<Location> getAreaPinInCity(int cityId);

	public List<Location> getAll();

	public Location update(Location location);

	public void delete(int locationId);

	public Location addLocation(Location location);
}
