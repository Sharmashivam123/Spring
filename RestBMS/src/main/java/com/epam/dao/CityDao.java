package com.epam.dao;

import org.springframework.data.repository.CrudRepository;

import com.epam.bean.City;

public interface CityDao extends CrudRepository<City, Integer> {
}
