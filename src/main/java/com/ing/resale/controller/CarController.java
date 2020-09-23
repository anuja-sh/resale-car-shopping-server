package com.ing.resale.controller;

import java.util.List;

import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ing.resale.model.Car;
import com.ing.resale.service.ICarService;

@RestController
public class CarController {

	@Autowired
	private ICarService carService;

	/**
	 * 
	 * @param order    {@value asc || desc}
	 * @param property property of the Car.
	 * @return {@link List<Car>}
	 */
	@GetMapping("/cars")
	@CrossOrigin(origins = "*")
	public List<Car> getListOfCars(@RequestParam String order, @RequestParam String property) {
		return carService.getListOfCars(order, property);
	}

	/**
	 * This method loads the initial data to database
	 * 
	 * @param data
	 * @return {@link ResponseEntity}
	 * @throws ParseException
	 */
	@PostMapping("/cars")
	@CrossOrigin(origins = "*")
	public ResponseEntity<String> loadCars(@RequestBody String data) throws ParseException {

		return carService.loadData(data);
	}

}
