package com.example.handmadeapi.services;

import com.example.handmadeapi.entity.HouseEntity;
import com.example.handmadeapi.repository.HousesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HouseService {

    private final HousesRepository housesRepository;

    @Autowired
    public HouseService(HousesRepository housesRepository) {
        this.housesRepository = housesRepository;
    }

    public List<HouseEntity> getAllHouses() {
        return (List<HouseEntity>) housesRepository.findAll();
    }

    public void addHouse(HouseEntity house) {
        housesRepository.save(house);
    }
}
