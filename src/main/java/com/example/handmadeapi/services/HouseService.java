package com.example.handmadeapi.services;

import com.example.handmadeapi.entity.HouseEntity;
import com.example.handmadeapi.repository.HousesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HouseService {

    private final HousesRepository housesRepository;

    @Autowired
    public HouseService(HousesRepository housesRepository) {
        this.housesRepository = housesRepository;
    }

    public List<HouseEntity> getAll() {
        return (List<HouseEntity>) housesRepository.findAll();
    }

    public HouseEntity getById(Long houseId) {
        return housesRepository.findById(houseId).get();
    }

    public void add(ArrayList<HouseEntity> houses) {
        housesRepository.saveAll(houses);
    }

    public void update(HouseEntity house) {
        HouseEntity houseToUpdate = housesRepository.findById(house.getId()).get();
        houseToUpdate.setName(house.getName());
        housesRepository.save(houseToUpdate);
    }

    public void delete(Long[] housesId) {
        for (Long id : housesId) {
            housesRepository.deleteById(id);
        }
    }
}
