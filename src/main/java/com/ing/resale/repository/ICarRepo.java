package com.ing.resale.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ing.resale.model.Car;

public interface ICarRepo extends MongoRepository<Car, Integer> {

}
