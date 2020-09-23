package com.resale.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.resale.model.WareHouse;
import com.resale.repository.IWareHouseRepo;
import com.resale.service.IWareHouseService;

@Service
public class WareHouseService implements IWareHouseService {

	@Autowired
	IWareHouseRepo wareHouseRepo;

	public List<WareHouse> getListOfWareHouses() {
		return wareHouseRepo.findAll();
	}

	public Map<String, Object> getWareHouseDetails(int carId) {
		HashMap<String, Object> wareHouseDetails = new HashMap<String, Object>();
		WareHouse ws = wareHouseRepo.findWareHouse(carId);
		wareHouseDetails.put("location", ws.getLocation());
		wareHouseDetails.put("name", ws.getName());
		wareHouseDetails.put("id", ws.getId());
		return wareHouseDetails;

	}
}
