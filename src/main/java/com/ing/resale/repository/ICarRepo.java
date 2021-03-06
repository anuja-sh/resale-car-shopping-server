package com.ing.resale.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ing.resale.model.Car;

/**
 * Dao interface for Car model
 * 
 * @author Anuja
 *
 */

@Repository
public interface ICarRepo extends MongoRepository<Car, Integer> {


}