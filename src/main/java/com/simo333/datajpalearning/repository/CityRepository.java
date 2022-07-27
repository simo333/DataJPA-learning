package com.simo333.datajpalearning.repository;

import com.simo333.datajpalearning.model.City;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends CrudRepository<City, Long> {
}
