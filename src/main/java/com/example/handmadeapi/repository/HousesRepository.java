package com.example.handmadeapi.repository;

import com.example.handmadeapi.entity.HouseEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HousesRepository extends CrudRepository<HouseEntity, Long> {
    void deleteAllById(Long[] housesId);
}
