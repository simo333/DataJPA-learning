package com.simo333.datajpalearning.service;

import com.simo333.datajpalearning.exception.ApiRequestException;
import com.simo333.datajpalearning.model.City;
import com.simo333.datajpalearning.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService implements ServicePattern<City> {
    private final CityRepository cityRepository;

    @Autowired
    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @Override
    public City add(City toAdd) {
        return cityRepository.save(toAdd);
    }

    @Override
    public List<City> getAll() {
        return cityRepository.findAll();
    }

    @Override
    public City getOne(Long id) {
        return cityRepository.findById(id)
                .orElseThrow(() -> new ApiRequestException("City with id " + id + " was not found", HttpStatus.NOT_FOUND));
    }

    @Override
    public void delete(Long id) {
        cityRepository.deleteById(id);
    }

    @Override
    public City edit(Long id, City city) {
        City cityToEdit = getOne(id);
        cityToEdit.setName(city.getName());
        return cityToEdit;
    }
}
