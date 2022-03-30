package com.example.handmadeapi.controllers;

import com.example.handmadeapi.entity.HouseEntity;
import com.example.handmadeapi.services.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/houses")
public class HousesController {

    private final HouseService houseService;

    @Autowired
    public HousesController(HouseService houseService) {
        this.houseService = houseService;
    }


    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(houseService.getById(id));
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity getAll() {
        try {
            return ResponseEntity.ok(houseService.getAll());
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/addAll")
    public ResponseEntity addAll(@RequestBody ArrayList<HouseEntity> houses) {
        try {
            houseService.add(houses);
            return ResponseEntity.ok("Add successes");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Already contains");
        }
    }

    @PostMapping
    public ResponseEntity add(@RequestBody HouseEntity house) {
        try {
            houseService.add(house);
            return ResponseEntity.ok("Add successes");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Already contains");
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity update(@PathVariable Long id, @RequestBody HouseEntity house){
        try {
            house.setId(id);
            houseService.update(house);
            return ResponseEntity.ok("House is updated");
        } catch (EmptyResultDataAccessException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        try {
            houseService.delete(id);
            return ResponseEntity.ok("House is deleted");
        } catch (EmptyResultDataAccessException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
