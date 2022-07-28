package com.simo333.datajpalearning.repository;

import com.simo333.datajpalearning.model.Zipcode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ZipcodeRepository extends JpaRepository<Zipcode, Long> {
}
