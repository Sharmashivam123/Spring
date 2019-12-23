package com.epam.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.epam.bean.Location;

public interface LocationDao extends CrudRepository<Location, Integer> {

	List<Location> findAllByCityId(int cityId);

}
