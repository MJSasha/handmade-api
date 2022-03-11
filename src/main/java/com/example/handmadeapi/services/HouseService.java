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

    public List<HouseEntity> getAll() {
        return (List<HouseEntity>) housesRepository.findAll();
    }

    public HouseEntity getById(Long houseId) {
        return (HouseEntity) housesRepository.findById(houseId).get();
    }

    public void add(HouseEntity house) {
        housesRepository.save(house);
    }

    public void delete(Long houseId){
        housesRepository.deleteById(houseId);
    }
}
