package com.ing.resale.controller;



import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ing.resale.model.WareHouse;
import com.ing.resale.service.IWareHouseService;


@RestController
public class WareHouseController {

	@Autowired
	private IWareHouseService wareHouseService;

	@GetMapping("/wareHouses")
	@CrossOrigin(origins = "*")
	public List<WareHouse> getListOfWareHouses() {
		return wareHouseService.getListOfWareHouses();
	}
	
	@GetMapping("/wareHouse/{carId}")
	@CrossOrigin(origins = "*")
	public Map<String, Object> getWareHouseDetais(@PathVariable int carId) {
		return wareHouseService.getWareHouseDetails(carId);
	}

}
