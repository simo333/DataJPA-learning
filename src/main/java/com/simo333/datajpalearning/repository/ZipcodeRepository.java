package com.simo333.datajpalearning.repository;

import com.simo333.datajpalearning.model.Zipcode;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ZipcodeRepository extends CrudRepository<Zipcode, Long> {
}
