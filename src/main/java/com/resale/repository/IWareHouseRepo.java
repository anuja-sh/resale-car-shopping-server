package com.resale.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.resale.model.WareHouse;

public interface IWareHouseRepo extends MongoRepository<WareHouse, Integer> {

}
