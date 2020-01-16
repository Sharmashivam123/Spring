package com.epam.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.epam.bean.Location;
import com.epam.util.Constants;

public interface LocationDao extends CrudRepository<Location, Integer> {

	@Query(nativeQuery = true, value = Constants.LOCATION_BY_CITY_QUERY)
	List<Location> findAllByCityId(int cityId);

}
