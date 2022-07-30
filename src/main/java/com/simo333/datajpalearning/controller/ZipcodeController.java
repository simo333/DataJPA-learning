package com.simo333.datajpalearning.controller;

import com.simo333.datajpalearning.exception.ApiRequestException;
import com.simo333.datajpalearning.model.Zipcode;
import com.simo333.datajpalearning.repository.ZipcodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestControllerAdvice
@RequestMapping("/zipcodes")
public class ZipcodeController {

    private final ZipcodeRepository zipcodeRepository;

    @Autowired
    public ZipcodeController(ZipcodeRepository zipcodeRepository) {
        this.zipcodeRepository = zipcodeRepository;
    }

    /* TODO fix: org.hibernate.PersistentObjectException: detached entity passed to persist: com.simo333.datajpalearning.model.City */
    @PostMapping
    public ResponseEntity<Zipcode> addZipcode(@RequestBody Zipcode zipcode) {
        Zipcode addedZipcode = zipcodeRepository.save(zipcode);
        return new ResponseEntity<>(addedZipcode, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Zipcode>> getAllZipcodes() {
        List<Zipcode> zipcodes = zipcodeRepository.findAll();
        return new ResponseEntity<>(zipcodes, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Zipcode> getZipcode(@PathVariable("id") Long id) {
        Zipcode zipcode = zipcodeRepository.findById(id)
                .orElseThrow(() -> new ApiRequestException("Zipcode with id " + id + " was not found", HttpStatus.NOT_FOUND));
        return new ResponseEntity<>(zipcode, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Zipcode> updateZipcode(@PathVariable("id") Long id, @RequestBody Zipcode zipcode) {
        getZipcode(id);
        zipcode.setId(id);
        Zipcode editedZipcode = zipcodeRepository.save(zipcode);
        return new ResponseEntity<>(editedZipcode, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteZipcode(@PathVariable("id") Long id) {
        zipcodeRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
