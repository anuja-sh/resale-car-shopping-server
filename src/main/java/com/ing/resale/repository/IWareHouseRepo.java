package com.ing.resale.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.ing.resale.model.WareHouse;

public interface IWareHouseRepo extends MongoRepository<WareHouse, Integer> {
	/**
	 * This method searches for the warehouse details based on the carId.
	 * @param carId
	 * @return
	 */
	@Query("{'carList._id':?0}")
	WareHouse findWareHouse(int carId);
}
