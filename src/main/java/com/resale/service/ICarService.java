package com.resale.service;

import java.util.List;

import org.json.simple.parser.ParseException;
import org.springframework.http.ResponseEntity;

import com.resale.model.Car;

public interface ICarService {

	/**
	 * 
	 * @param order
	 * @param property
	 * @return @{link List<Car>}
	 */
	List<Car> getListOfCars(String order, String property);

	/**
	 * 
	 * @param data
	 * @return {@link ResponseEntity<String}
	 * @throws ParseException
	 */
	ResponseEntity<String> loadData(String data) throws ParseException;

}
