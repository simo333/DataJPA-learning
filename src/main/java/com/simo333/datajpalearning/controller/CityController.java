package com.simo333.datajpalearning.controller;

import com.simo333.datajpalearning.model.City;
import com.simo333.datajpalearning.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cities")
public class CityController {
    private final CityService cityService;

    @Autowired
    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @PostMapping
    public ResponseEntity<City> addCity(@RequestBody City city) {
        City addCity = cityService.add(city);
        return new ResponseEntity<>(addCity, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<City>> getAllCities() {
        List<City> cities = cityService.getAll();
        return new ResponseEntity<>(cities, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<City> getCity(@PathVariable("id") Long id) {
        City city = cityService.getOne(id);
        return new ResponseEntity<>(city, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<City> editCity(@PathVariable("id") Long id,
                                         @RequestBody City city) {
        City editCity = cityService.edit(id, city);
        return new ResponseEntity<>(editCity, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCity(@PathVariable("id") Long id) {
        cityService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
