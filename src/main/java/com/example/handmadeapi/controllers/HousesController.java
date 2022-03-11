package com.example.handmadeapi.controllers;

import com.example.handmadeapi.entity.HouseEntity;
import com.example.handmadeapi.services.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/houses")
public class HousesController {

    private final HouseService houseService;

    @Autowired
    public HousesController(HouseService houseService) {
        this.houseService = houseService;
    }


    @GetMapping("/{id}")
    public ResponseEntity getHouseById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(houseService.getHouseById(id));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity getHouses() {
        return ResponseEntity.ok(houseService.getAllHouses());
    }

    @PostMapping()
    public ResponseEntity addHouse(@RequestBody HouseEntity house) {
        try {
            houseService.addHouse(house);
            return ResponseEntity.ok("Add successes");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Already contains");
        }
    }
}
