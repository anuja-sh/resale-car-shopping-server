package com.resale.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.resale.model.WareHouse;

public interface IWareHouseRepo extends MongoRepository<WareHouse, Integer> {
	@Query("{'carList._id':?0}")
	WareHouse findWareHouse(int carId);
}
