package com.ing.resale.service;

import java.util.List;

import org.json.simple.parser.ParseException;
import org.springframework.http.ResponseEntity;

import com.ing.resale.model.Car;

public interface ICarService {

	/**
	 * Fetches entire list of cars
	 * @param order
	 * @param property
	 * @return @{link List<Car>}
	 */
	List<Car> getListOfCars(String order, String property);

	/**
	 * Loads the seed data in DB
	 * @param data
	 * @return {@link ResponseEntity<String}
	 * @throws ParseException
	 */
	ResponseEntity<String> loadData(String data) throws ParseException;

}
