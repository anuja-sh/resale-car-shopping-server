package com.resale.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.resale.model.WareHouse;

@Service
public interface IWareHouseService {

	Map<String, Object> getWareHouseDetails(int carId);

	List<WareHouse> getListOfWareHouses();

}
